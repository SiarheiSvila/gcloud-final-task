package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.stream.Collectors;

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
		return this.jdbcTemplate.queryForList("SELECT * FROM val").stream()
				.map((m) -> m.values().toString())
				.collect(Collectors.toList());
	}
}
