package com.example.skills.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.skills.Domain.User;
import com.example.skills.Repository.userRepository;

@Controller
public class UserController {
	
	@Autowired
	private userRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping({"/",""})
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/user/join")
	public String getJoin() {
		return "joinForm";
	}
	
	@PostMapping("/join")
	public  String joinProc(User user) {
		String rawPass=user.getPassword();
		String encodedPass = bCryptPasswordEncoder.encode(rawPass);
		user.setPassword(encodedPass);
		
		userRepository.save(user);
		return "redirect:/";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "loginForm";
	}
}
