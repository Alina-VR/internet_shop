package com.example.models;


import org.springframework.security.core.GrantedAuthority;

/**
 * Класс, содержащий роли
 */
public enum Role implements GrantedAuthority {
    /**
     * Роли.
     */
    USER, ADMIN;

    /**
     * Получает роли.
     *
     * @return name() объект String.
     *
     * @throws Exception
     */
    @Override
    public String getAuthority() {
        return name();
    }
}