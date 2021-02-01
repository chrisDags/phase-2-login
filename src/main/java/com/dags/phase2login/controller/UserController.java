package com.dags.phase2login.controller;

import com.dags.phase2login.entity.User;
import com.dags.phase2login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView showLogin(){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") User user){

        if(userService.isLoginFormValid(user.getUsername(), user.getPassword())){
            return new ModelAndView("index");
        }

        return new ModelAndView("error-bad-login");
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("user")User user, BindingResult bindingResult){

        // If isRegistrationBindingValid returns false, return the error page for registration
        if(!userService.isRegistrationBindingValid(bindingResult, user))
            return new ModelAndView("error-bad-registration");


        // register the user if a user with the same username doesn't already exist in the db then display the login page
        if(userService.userDoesNotExist(user.getUsername())){
            userService.registerUser(user.getUsername(), user.getPassword());
            return new ModelAndView("login");
        }

        // navigate to the appropriate error page if the user already exists
        return new ModelAndView("error-user-already-exists");
    }

    @GetMapping("/register")
    public ModelAndView displayRegister(){
        return new ModelAndView("register");
    }


}
