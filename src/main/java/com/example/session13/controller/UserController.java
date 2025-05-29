package com.example.session13.controller;

import com.example.session13.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("welcomeLogin")
    public String welcomeLogin(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        return "welcomeLogin";
    }

    @PostMapping("login-submit")
    public String loginSubmit(@ModelAttribute("user") User user, HttpSession session, Model model) {
        if(user.getUsername().equals("user1") && user.getPassword().equals("12345")) {
            session.setAttribute("user", user);
            return "welcomeLogin";
        }else {
            model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
            return "login";
        }
    }
}
