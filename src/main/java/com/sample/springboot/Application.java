package com.sample.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.springboot.message.Message;
import com.sample.springboot.message.MessageRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(MessageRepository messageRepository) {
		return args -> {
			Arrays.asList("Madhu,Sudhan,Sastry".split(",")).forEach(n -> messageRepository.save(new Message(n)));

			messageRepository.findAll().forEach(System.out::println);
		};

	}
}
