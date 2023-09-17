package com.example.skills.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	

	
	// 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
		  	.csrf().disable()//CSRF(Cross-Site Request Forgery) 토큰을 비활성화합니다. 테스트를 위해 임시로 비활성화하는 것으로 보입니다.
			.authorizeRequests()// 요청에 대한 인가 규칙을 설정합니다.
				//.antMatchers("/user/**","/").authenticated()//인증이 필요한 주소
				.antMatchers("/user/**","/").permitAll()
				// 굳이 hasRole 부분에 "ROLE_ADMIN"안해도 알아서 "ROLE_"을 붙여줌
				.antMatchers("/auth/user").hasAnyRole("ADMIN","USER")
				.antMatchers("/auth/admin").hasRole("ADMIN")
		 		.and()
		 		.formLogin()
		 		.loginPage("/user/login") // 여기까지는 성공
		 		//.usernameParameter(null) -> 만약 파라미터를 바꾸고 싶은 경우.
		 		.loginProcessingUrl("/login") // login 주소가 호출이 되면, 시큐리티가 낚아채서 대신 로그인을 해준다. 		
		 		.defaultSuccessUrl("/");
        return http.build();
    }
}
