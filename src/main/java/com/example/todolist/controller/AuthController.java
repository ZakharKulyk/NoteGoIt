package com.example.todolist.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthController {
    @GetMapping("/registration_page")
    public ModelAndView getRegistrationForm(){
        return new ModelAndView("registration_page");
    }

    @PostMapping("/submit_registration")
    public String processRegistration(){
        // process user and insert him into db and return to the registration form
        return null;
    }
}
