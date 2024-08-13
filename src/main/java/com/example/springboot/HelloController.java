package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;

@RestController
public class HelloController {

	private final JdbcTemplate jdbcTemplate;

	public HelloController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/query")
	public List<String> printSecrets() {
		System.out.println("Let's inspect the beans provided by Spring Boot:");

		return this.jdbcTemplate.queryForList("SELECT * FROM vals").stream()
				.map((m) -> m.values().toString())
				.collect(Collectors.toList());
	}
}
