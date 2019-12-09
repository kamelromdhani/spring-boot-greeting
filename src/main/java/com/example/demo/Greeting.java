package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

	@GetMapping("/{name}")
	String greeting(@PathVariable String name) {
		return "Hello "+ name;
	}
	
	@GetMapping("/")
	String hello() {
		return "Hello world";
	}
}
