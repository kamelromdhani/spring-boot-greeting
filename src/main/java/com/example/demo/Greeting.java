package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class Greeting {
	
	@Autowired
	UserRepository userRepository;
	
	
   

	@GetMapping("/{name}")
	String greeting(@PathVariable String name) {
		return "Hello "+ name;
	}
	
	@GetMapping("/")
	String hello() {
		return "Hello world";
	}
	
	@GetMapping("/user/{id}")
	UserDto getUserById(@PathVariable Long id){
		if(userRepository.findById(id).isPresent()) {
			User user = userRepository.findById(id).get();
			UserDto userDto = new UserDto(user.getId(), user.getFirstname());
			return userDto;
		}
		return null ;
	}
	


    @PostMapping(value = "/")
    public UserDto createUser(@RequestBody UserCandidate userCandidate) {
        User user = new User(userCandidate.getName());
        user = userRepository.save(user);
        UserDto userDto = new UserDto(user.getId(), user.getFirstname());
		return userDto;
    }
	
	
}
