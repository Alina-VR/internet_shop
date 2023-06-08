package com.example.services;

import static com.example.models.Role.ADMIN;
import static com.example.models.Role.USER;
import com.example.models.User;
import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Пользовательский сервис, содержащий методы работы с пользователями.
 */
@Service
@Slf4j
@RequiredArgsConstructor
//@Component
public class UserService {

    /**
     * Репозиторий пользователей, используемый для поиска пользователей в базе данных.
     */
    private final UserRepository userRepository;

    /**
     * Содержит хэш пароля.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Создает пользователя.
     *
     * @param user объект User, то есть пользователь.
     *
     * @return true, если пользователь успешно создался.
     */
    public boolean createUser(User user) {
        String name= user.getName();
        if (userRepository.findByName(name) != null) return false;
        user.setActive(true);
        if (name.equals("admin")){
            user.getRoles().add(ADMIN);
        } else {
            user.getRoles().add(USER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User: {}", name);
        userRepository.save(user);
        return true;
    }
}
