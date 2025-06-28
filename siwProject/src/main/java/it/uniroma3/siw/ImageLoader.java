package it.uniroma3.siw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Image;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.repository.RecipeRepository;
import it.uniroma3.siw.service.ImageService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.*;

@Component
@Transactional
public class ImageLoader implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String recipeFolderPath = "recipeImages";
            System.out.println("Inizio caricamento immagini da: " + recipeFolderPath);
            assignImagesToRecipes(recipeFolderPath);
        } catch (IOException e) {
            System.err.println("ERRORE nel caricamento delle immagini: " + e.getMessage());
        }
    }

    @Transactional
    private void assignImagesToRecipes(String folderPath) throws IOException {
        Map<Long, List<Resource>> recipeImagesMap = new HashMap<>();
        List<Resource> imageResources = getImageResourcesFromFolder(folderPath);

        System.out.println("Trovati " + imageResources.size() + " file immagine nella cartella: " + folderPath);

        // Raggruppa le immagini per ID ricetta (estratto da nome file)
        for (Resource resource : imageResources) {
            String fileName = resource.getFilename();
            System.out.println("Elaborazione file: " + fileName);
            String[] parts = fileName.split("_");

            if (parts.length >= 1) {
                try {
                    Long recipeId = Long.parseLong(parts[0]);
                    System.out.println(" → ID ricetta estratto: " + recipeId);
                    recipeImagesMap.computeIfAbsent(recipeId, k -> new ArrayList<>()).add(resource);
                } catch (NumberFormatException e) {
                    System.err.println("ERRORE: ID non valido nel file: " + fileName);
                }
            } else {
                System.err.println("ERRORE: nome file non conforme (manca '_'): " + fileName);
            }
        }

        // Assegna le immagini alle ricette
        for (Map.Entry<Long, List<Resource>> entry : recipeImagesMap.entrySet()) {
            Long recipeId = entry.getKey();
            List<Resource> resources = entry.getValue();

            System.out.println("→ Assegnazione immagini a ricetta ID: " + recipeId + " (" + resources.size() + " file)");

            Optional<Recipe> recipeOpt = recipeRepository.findById(recipeId);

            if (recipeOpt.isPresent()) {
                Recipe recipe = recipeOpt.get();

                for (Resource resource : resources) {
                    System.out.println("  → Caricamento immagine: " + resource.getFilename());

                    Image image = processImage(resource);

                    if (image == null) {
                        System.err.println("    ERRORE: Immagine null per file: " + resource.getFilename());
                        continue;
                    }

                    recipe.addImage(image);
                    image.setRecipe(recipe);

                    imageService.saveImage(image);
                    System.out.println("    Immagine salvata: " + image.getName());
                }

                recipeRepository.save(recipe);
                System.out.println("✔ Ricetta " + recipe.getId() + " salvata con " + recipe.getImages().size() + " immagini.");
            } else {
                System.err.println("ERRORE: ricetta non trovata per ID: " + recipeId);
            }
        }

        System.out.println("✅ Associazione immagini completata.");
    }

    private List<Resource> getImageResourcesFromFolder(String folderPath) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/static/" + folderPath + "/*");
        return Arrays.asList(resources);
    }

    private Image processImage(Resource resource) {
        try {
            Optional<Image> existingImage = imageService.findByName(resource.getFilename());

            if (existingImage.isPresent()) {
                System.out.println("    → Immagine già esistente: " + resource.getFilename());
                return existingImage.get();
            } else {
                return createImageFromResource(resource);
            }
        } catch (IOException e) {
            System.err.println("    ERRORE nel processing immagine: " + resource.getFilename());
            return null;
        }
    }

    private Image createImageFromResource(Resource resource) throws IOException {
        Image newImage = new Image();
        newImage.setName(resource.getFilename());
        newImage.setData(resource.getInputStream().readAllBytes());
        return newImage;
    }
}
