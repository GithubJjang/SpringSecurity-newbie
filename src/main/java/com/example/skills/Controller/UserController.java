package com.example.skills.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.skills.Domain.Roletype;
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
		
		// 비밀번호 암호화
		String rawPass=user.getPassword();
		String encodedPass = bCryptPasswordEncoder.encode(rawPass);
		user.setPassword(encodedPass);
		
		// 아이디가 root -> admin 권한을 부여하자.
		String getUser = user.getName();
		if(getUser.equals("root")) {
			// ADMIN 권한을 부여한다.
			user.setRoletype(Roletype.ROLE_ADMIN);
		}
		else {
			// USER 권한을 부여한다.
			user.setRoletype(Roletype.ROLE_USER);
		}
		
		userRepository.save(user);
		return "redirect:/";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "loginForm";
	}
	
	// 권한이 필요한 페이지
	// USER와 ADMIN 둘다 접근이 가능
	@GetMapping("/auth/user")
	public String userAccess() {
		return "/authpage/user";
	}
	// ADMIN만 접근이 가능
	@GetMapping("/auth/admin")
	public String adminOnly() {
		return "/authpage/admin";
	}
	
	
}
