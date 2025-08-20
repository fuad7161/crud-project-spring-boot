package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("POSTGRES_USER", dotenv.get("POSTGRES_USER"));
        System.setProperty("USER_PASSWORD", dotenv.get("USER_PASSWORD"));
		SpringApplication.run(DemoApplication.class, args);
	}
}
