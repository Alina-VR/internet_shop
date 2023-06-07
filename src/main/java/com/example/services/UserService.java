package com.example.services;

import com.example.models.Role;
import com.example.models.User;
//import com.example.models.Role;
import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
//@Component
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
//    private final CustomUserDetailsService userDetailsService;

    public boolean createUser(User user) {
        String name= user.getName();
        if (userRepository.findByName(name) != null) return false;
        user.setActive(true);
        if (name.equals("admin")){
            user.getRoles().add(Role.ADMIN);
        } else {
            user.getRoles().add(Role.USER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User: {}", name);
        userRepository.save(user);
        return true;
    }
}
