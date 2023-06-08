package com.example.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер, поддерживающий корневую страницу.
 */
@Controller
@RequiredArgsConstructor
public class HomePageController {

    /**
     * Поддерживает информацию, отображаемую на корневой странице.
     *
     * @param model объект Model, то есть сущность домашней страницы.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     *
     */
    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("home-page");
        return "home-page";
    }

}
