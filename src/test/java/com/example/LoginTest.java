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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = InternetShopApplicationTests.class)
@AutoConfigureMockMvc
//@TestPropertySource("/application-test.properties")
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
    public void accessDeniedTest() throws Exception {
        this.mockMvc.perform(get("/menu"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }
}

