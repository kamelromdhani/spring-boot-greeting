package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.engine.Producer;



@RestController
public class Greeting {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private Producer producer;
   

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
	


    @PostMapping(value = "/publish/string")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
	
	
}
