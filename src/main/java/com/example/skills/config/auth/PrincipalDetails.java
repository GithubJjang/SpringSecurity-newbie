package com.example.skills.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.skills.Domain.User;

public class PrincipalDetails implements UserDetails{

	private User user;
	private String username;
	private String password;
	
	public PrincipalDetails(User user) {
		this.user=user;
		username=user.getName();
		password=user.getPassword();
	}
	
	// getter-setter
	// jstl을 사용해서, jsp로 넘긴 객체의 attribute에 접근할 수 있다.
	// ex)${principal.username} -> principal의 username 변수에 접근.
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	// 해당 User의 권한을 리턴하는 곳 -> 업데이트 예정!
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auth = new ArrayList<>();
		// auth에 권한을 추가한다.
		
		// GrantedAuthority -> 인터페이스
		// SimpleGrantedAuthority -> 위 인터페이스의 클래스
		// 주로 SimpleGrantedAuthority를 이용해서 권한 객체를 만든다.
		auth.add(new SimpleGrantedAuthority(user.getRoletype().toString()));
		
		return auth;
		
	}
	//
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}

