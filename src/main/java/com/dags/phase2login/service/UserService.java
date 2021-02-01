package com.dags.phase2login.service;

import com.dags.phase2login.entity.User;
import com.dags.phase2login.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@Log
public class UserService {

    @Autowired
    UserRepository userRepository;

    // Logs the user in if the username and password exist in the database
    public boolean isLoginFormValid(String username, String password){
        if(userRepository.existsByUsernameAndPassword(username, password)){
            return true;
        }

        log.warning("User tried logging in with invalid credentials");
        return false;
    }

    // returns false if the username that the user wants already exists in the database
    public boolean userDoesNotExist(String username){
        if (userRepository.existsByUsername(username)){
            log.warning("User tried to register with a pre-existing username.");
            return false;
        }
        return true;
    }

    public boolean isRegistrationBindingValid(BindingResult bindingResult, User user){
        return !bindingResult.hasErrors() && !user.getUsername().contains(" ") && !user.getPassword().contains(" ");
    }



    // saves a new User to the database
    public void registerUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        log.info("Registered user: '" + username + "' to the database.");
    }
}
