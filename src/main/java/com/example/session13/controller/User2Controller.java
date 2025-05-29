package com.example.session13.controller;

import com.example.session13.model.Use2;
import com.example.session13.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class User2Controller {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new Use2());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("user") Use2 user,
                                      BindingResult result, Model model) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "password.mismatch");
        }

        if (result.hasErrors()) {
            return "register";
        }

        model.addAttribute("successMessage", "register.success");
        return "register";
    }
}