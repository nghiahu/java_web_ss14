package com.example.session13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultilingualController {

    @GetMapping("multilingual")
    public String multilingual() {
        return "multilingual";
    }
}
