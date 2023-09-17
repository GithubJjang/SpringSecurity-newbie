# SpringSecurity-newbie
스프링 시큐리티를 이용한 매우 간단한 로그인 구현

# 작동법:
회원가입(username,password) -> MySql에 저장 및 index로 되돌아감 -> 로그인 페이지로 이동 -> loginForm을 이용한 로그인 인풋입력 ->
login처리를 스프링시큐리티가 가로채서 PrincipalDetailsService로 이동(중요!) -> 만약 일치하는 데이터를 DB에서 찾은 경우, 해당 데이터를 PrincipalDetails로 캡슐화한 후, 리턴(중요!)
-> jsp에서 security태그를 통해서 해당 권한에 접근 가능함.

# 수정할 부분:
작업 권한(ADMIN,USER,...)에 따른 차별적으로 접근 가능한 페이지 구현.
리팩토링 필요
기타 기능 추가

