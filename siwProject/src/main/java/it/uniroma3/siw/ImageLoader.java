package it.uniroma3.siw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import it.uniroma3.siw.model.Image;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.repository.RecipeRepository;
import it.uniroma3.siw.service.ImageService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ImageLoader implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String recipeFolderPath = "src/main/resources/databaseImage/recipeImages";

            assignImagesToRecipes(recipeFolderPath);

        } catch (IOException e) {
            System.err.println("Errore nel caricamento delle immagini.");
        }
    }

    private void assignImagesToRecipes(String folderPath) throws IOException {
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        List<File> imageFiles = getImageFilesFromFolder(folderPath);

        for (int i = 0; i < recipes.size() && i < imageFiles.size(); i++) {
            Recipe recipe = recipes.get(i);
            File imageFile = imageFiles.get(i);
            processImage(recipe.getImages()::add, imageFile);
            recipeRepository.save(recipe);
        }
        System.out.println("Immagini ricette associate con successo!");
    }

    private List<File> getImageFilesFromFolder(String folderPath) throws IOException {
        return Files.list(Path.of(folderPath))
                   .filter(Files::isRegularFile)
                   .map(Path::toFile)
                   .collect(Collectors.toList());
    }

    private void processImage(java.util.function.Consumer<Image> setter, File imageFile) {
        Optional<Image> existingImage = imageService.findByName(imageFile.getName());
        Image image = existingImage.orElseGet(() -> createNewImage(imageFile));
        setter.accept(image);
    }

    private Image createNewImage(File imageFile) {
        Image newImage = new Image();
        newImage.setName(imageFile.getName());
        try {
            newImage.setData(Files.readAllBytes(imageFile.toPath()));
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + imageFile.getName());
        }
        return imageService.saveImage(newImage);
    }
}