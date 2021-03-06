package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/add")
	@ResponseBody
	public User addNewUser (@RequestBody User user) {		
		
		userRepository.save(user);
		
		return user;
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {

		return userRepository.findAll();

	}
}
