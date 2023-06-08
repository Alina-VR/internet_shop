package com.example.configurations;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.models.User;
import com.example.repositories.UserRepository;

/**
 * Класс, используемый аутенфикации пользователей.
 */
@Component
public class AuthProvider implements AuthenticationProvider
{

    /**
     * Репозиторий пользователей, используемый для поиска пользователей в базе данных.
     */
    @Autowired UserRepository userRepository;

    /**
     * Аутентифицирует пользователя на основе его имени и пароля.
     *
     * @param authentication объект Authentication, содержащий имя пользователя и пароль.
     *
     * @return объект Authentication, представляющий аутентифицированного пользователя.
     *
     * @throws BadCredentialsException если имя пользователя или пароль неверны.
     */
    public Authentication authenticate(Authentication authentication)
    {
        String name = authentication.getName();
        String password = (String)authentication.getCredentials();

        User user = userRepository.findByName(name);

        if (user != null && (user.getUsername().equals(name)))
        {
            if (!new BCryptPasswordEncoder().matches(password, user.getPassword()))
            {
                throw new BadCredentialsException("Wrong password");
            }
            Collection<? extends GrantedAuthority> authorities = user.getRoles();
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        }
        else
        {
            throw new BadCredentialsException("Username not found");
        }
    }

    /**
     * Проверяет, поддерживается ли данный тип аутентификации.
     *
     * @param arg тип аутентификации, поддержка которого должна быть проверена.
     *
     * @return true, поскольку единственный возможный тип аутентификации поддерживается.
     */
    public boolean supports(Class<?> arg)
    {
        return true;
    }
}
