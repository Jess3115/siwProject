package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired UserRepository userRepository;

    public void saveUser(User user) {
       this.userRepository.save(user);
    }
}
