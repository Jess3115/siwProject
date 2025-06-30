package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Grading;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired UserRepository userRepository;

	@Transactional
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

    @Transactional
	public User getUser(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}
	
	public Iterable<User> getAllUser(){
		return this.userRepository.findAll();
	}

    @Transactional
    public Double getAverage(Long id) {
        User user = this.userRepository.findById(id).orElse(null);
		if (user == null) {
			return 0.0;
		}

		double totalRating = 0.0;
		int count = 0;

		for (Recipe recipe : user.getCreatedRecipes()) {
			for (Grading grading : recipe.getGradings()) {
				totalRating += grading.getValue();
				count++;
			}
		}

		return count > 0 ? totalRating / count : 0.0;
    }
}
