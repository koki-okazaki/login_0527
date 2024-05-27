package com.example.teamA3_okazaki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String registerUser(@RequestParam String username, @RequestParam String password) {
		userService.registerNewUser(username, password);
		return "User registered successfully";
	}

	@GetMapping("/login")
	public String loginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return "Logged in as: " + userDetails.getUsername();
	}
}
