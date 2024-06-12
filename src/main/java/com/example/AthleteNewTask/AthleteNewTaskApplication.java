package com.example.AthleteNewTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.AthleteNewTask.client")
public class AthleteNewTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthleteNewTaskApplication.class, args);
	}

}
