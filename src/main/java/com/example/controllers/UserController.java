package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
//@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String loginUser() {
//        return "redirect:/";
//    }
//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration";
//        }
//        if (!userService.createUser(userForm)) {
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
//            return "login";
//        }
//
//        return "redirect:/";
//    }

        @GetMapping("/login")
        public String login() {
            return "login";
        }

//        @PostMapping("/login")
//        public String enter(){
//            return "redirect:/";
//        }

        @GetMapping("/registration")
        public String registration() {
            return "registration";
        }


        @PostMapping("/doRegister")
        public String doRegister(@RequestParam("name") String name, @RequestParam("email") String email,
                @RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password)
        {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            userService.createUser(user);
            return "redirect:/login";
        }
}
