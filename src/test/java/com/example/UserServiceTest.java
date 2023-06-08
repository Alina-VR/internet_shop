package com.example;

import com.example.models.Role;
import com.example.models.User;
import com.example.repositories.UserRepository;
import com.example.services.UserService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;


    @Test
    public void createUserTest() {
        User user = new User();

        user.setName("bob");
        user.setPassword("bb");
        user.setEmail("b@mail.ru");
        user.setPhoneNumber("000");

        boolean isUserCreated = userService.createUser(user);

        Assert.assertTrue(isUserCreated);
//        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Role.USER));
//        Mockito.verify(userService, Mockito.times(1)).createUser(ArgumentMatchers.any(User.class));
    }
}
