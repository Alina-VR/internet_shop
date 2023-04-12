package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MyRestService {
    @GetMapping("test")
    public String testRequest(@RequestParam("name") String name){
        return "Hello, " + name + "!";
    }
}
