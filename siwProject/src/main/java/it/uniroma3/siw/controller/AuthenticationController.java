package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.RecipeService;
import it.uniroma3.siw.service.UserService;
import it.uniroma3.siw.utils.SecurityUtils;
import jakarta.validation.Valid;

@Controller
public class AuthenticationController {

	@Autowired
	CredentialsService credentialsService;
	@Autowired
	UserService userService;
	@Autowired
	SecurityUtils securityUtils;
	@Autowired
	RecipeService recipeService;

	/*
	 * REGISTER FORM
	 */
	@GetMapping(value = "/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("credentials", new Credentials());
		return "formRegisterUser.html";
	}

	/*
	 * LOGIN FORM
	 */
	@GetMapping(value = "/login")
	public String showLoginForm(Model model) {
		return "formLogin";
	}

	/*
	 * INDEX
	 */
	@GetMapping(value = "/")
	public String index(Model model) {
		return "index.html";
	}

	/*
	 * LOGIN/REGISTER SUCCESS
	 */
	@GetMapping(value = "/success")
	public String defaultAfterLogin(Model model) {
		Credentials credentials = securityUtils.getCurrentCredentials(credentialsService);
		if (credentials != null && credentials.getRole().equals("ADMIN")) {
			return "index.html";
		}
		return "index.html";
	}

	/*
	 * PERSONAL AREA
	 */
	@GetMapping("/personalArea")
	public String personalArea(Model model) {
		if (!securityUtils.isAuthenticated()) {
			return "login";
		}

		Credentials credentials = securityUtils.getCurrentCredentials(credentialsService);
		model.addAttribute("credentials", credentials);
		model.addAttribute("user", credentials.getUser());
		model.addAttribute("likes", userService.getAverage(credentials.getUser().getId()));

		return "personalArea.html";
	}

	/*
	 * REGISTRAZIONE
	 */
	@PostMapping(value = { "/register" })
	public String registerUser(
			@Valid @ModelAttribute("user") User user,
			BindingResult userBindingResult,
			@Valid @ModelAttribute("credentials") Credentials credentials,
			@RequestParam("confirmPassword") String confirmPassword,
			BindingResult credentialsBindingResult,
			Model model) {

		if (!credentials.checkPassword(confirmPassword)) {
			System.out.println("Password mismatch!");
			credentialsBindingResult.rejectValue("password", "error.credentials", "Le password non coincidono");
		}

		System.out.println("User errors: " + userBindingResult.hasErrors());
		System.out.println("Credentials errors: " + credentialsBindingResult.hasErrors());

		if (userBindingResult.hasErrors()) {
			System.out.println("User validation errors: " + userBindingResult.getAllErrors());
		}

		if (credentialsBindingResult.hasErrors()) {
			System.out.println("Credentials validation errors: " + credentialsBindingResult.getAllErrors());
		}

		if (!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			try {
				User savedUser = userService.saveUser(user);
				System.out.println("User saved: " + savedUser);

				credentials.setUser(savedUser);
				Credentials savedCredentials = credentialsService.saveCredentials(credentials);
				System.out.println("Credentials saved: " + savedCredentials);

				model.addAttribute("user", savedUser);
				return "formLogin";
			} catch (Exception e) {
				System.out.println("Error saving user/credentials: " + e.getMessage());
				e.printStackTrace();
			}
		}

		model.addAttribute("user", user);
		model.addAttribute("credentials", credentials);
		return "formRegisterUser.html";
	}
}
