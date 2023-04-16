package com.example.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomePageController {
    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("home-page");
        return "home-page";
    }

}
