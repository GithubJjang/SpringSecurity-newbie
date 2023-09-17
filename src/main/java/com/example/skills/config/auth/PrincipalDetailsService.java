package com.example.skills.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.skills.Domain.User;
import com.example.skills.Repository.userRepository;

@Service // 문제의 원인: 바로 @Service를 쓰지 않아서 발생이 되었다.
public class PrincipalDetailsService implements UserDetailsService {
	@Autowired
	private userRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 중요한 팁:
		// 1. loginForm에서 무조건! <input type="text"  name="username" placeholder="username"/>
		// 만약, name에 다른 것을 입력하라 경우 파라미터를 가져오지 못함!

		User user = userRepository.findByname(username);
		if(user != null) {
			// 세션을 만들어서 리턴한다.
			return new PrincipalDetails(user);
		}

		return null;
	}

}
