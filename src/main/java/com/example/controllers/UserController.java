package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
            .containsAll(AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"))) {
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/doRegister")
    public String doRegister(@RequestParam("name") String name, @RequestParam("email") String email,
                             @RequestParam("phoneNumber") String phoneNumber,
                             @RequestParam("password") String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        userService.createUser(user);
        return "redirect:/login";
    }
}
