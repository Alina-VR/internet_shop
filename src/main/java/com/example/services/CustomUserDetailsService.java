package com.example.services;

import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Сервис, транслирующий методы репозитория.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * Репозиторий пользователей, используемый для поиска пользователей в базе данных.
     */
    private final UserRepository userRepository;

    /**
     * Ищет пользователя по его имени.
     *
     * @param name строка, содержащая имя пользователя.
     *
     * @return объект UserDetails, для искомого пользователя.
     *
     * @throws UsernameNotFoundException, если пользователь с таким именем не найден.
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name);
    }
}