package com.example.repositories;

import com.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий пользователей, используемый для поиска пользователей в базе данных.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Ищет пользователя по его имени.
     *
     * @param name строка, содержащая имя пользователя.
     *
     * @return объект User, то есть искомого пользователя.
     *
     */
    User findByName(String name);
}