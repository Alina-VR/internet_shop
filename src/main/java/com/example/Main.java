package com.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Main extends SpringBootServletInitializer {
	public static void main(String[] args){
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {
	}
}
