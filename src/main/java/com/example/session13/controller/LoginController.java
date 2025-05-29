package com.example.session13.controller;

import com.example.session13.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("loginForm")
    public String showLoginForm(Model model, HttpServletRequest request) {
        String rememberedUsername = "";
        String rememberedPassword = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    rememberedUsername = c.getValue();
                } else if (c.getName().equals("password")) {
                    rememberedPassword = c.getValue();
                }
            }
        }

        User user = new User(rememberedUsername, rememberedPassword);
        model.addAttribute("user", user);
        return "loginForm";
    }

    @PostMapping("login-save")
    public String processLogin(
            @ModelAttribute("user") User user,
            @RequestParam(value = "remember", required = false) String remember,
            HttpServletResponse response,
            Model model
    ) {

        if ("admin".equals(user.getUsername()) && "123".equals(user.getPassword())) {

            if (remember != null) {
                Cookie usernameCookie = new Cookie("username", user.getUsername());
                Cookie passwordCookie = new Cookie("password", user.getPassword());

                usernameCookie.setMaxAge(7 * 24 * 60 * 60);
                passwordCookie.setMaxAge(7 * 24 * 60 * 60);

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            } else {

                Cookie usernameCookie = new Cookie("username", null);
                usernameCookie.setMaxAge(0);
                Cookie passwordCookie = new Cookie("password", null);
                passwordCookie.setMaxAge(0);

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }

            model.addAttribute("username", user.getUsername());
            return "welcome";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "loginForm";
        }
    }
}