package com.example.demo.config;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class TestConfig implements CommandLineRunner{
	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		repository.saveAll(Arrays.asList(u1, u2));
	}

}
