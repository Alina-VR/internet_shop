package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер, поддерживающий страницы регистрации и логина.
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    /**
     * Пользовательский сервис, содержащий методы работы с пользователями.
     */
    private final UserService userService;

    /**
     * Поддерживает вход в систему.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     */
    @GetMapping("/login")
    public String login() {
            return "login";
        }

    /**
     * Поддерживает форму регистрации.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     */
    @GetMapping("/registration")
    public String registration() {
            return "registration";
        }

    /**
     * Поддерживает создание профиля поьлзователя.
     *
     * @param name объект String, то есть имя пользователя.
     *
     * @param email объект String, то есть адрес электронной почты пользователя.
     *
     * @param phoneNumber объект String, то есть номер телефона.
     *
     * @param password объект String, то есть пароль.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     *
     */
    @PostMapping("/doRegister")
    public String doRegister(@RequestParam("name") String name, @RequestParam("email") String email,
                             @RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        userService.createUser(user);
        return "redirect:/login";
    }
}
