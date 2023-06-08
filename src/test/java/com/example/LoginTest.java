package com.example;

import com.example.controllers.HomePageController;
import static org.hamcrest.Matchers.containsString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = InternetShopApplicationTests.class)
@AutoConfigureMockMvc

public class LoginTest {
    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private HomePageController controller;

//    @Test
//    public void test() throws Exception {
//        this.mockMvc.perform(get("/")).andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(content().string(containsString("Hello, Guest!")));
//    }

    @Test
    public void accessDeniedToMenuTest() throws Exception {
        this.mockMvc.perform(get("/menu"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }
    @Test
    public void accessDeniedToProductsTest() throws Exception {
        this.mockMvc.perform(get("/menu/product"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }
    @Test
    public void badCredentialsTest() throws Exception {
        this.mockMvc.perform(post("/login").param("username", "ann"))
            .andDo(print())
            .andExpect(status().isForbidden());
    }
}

