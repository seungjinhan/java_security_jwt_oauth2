package com.example.demo.manage.security.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 사용자 처리 서비스
 */
@Service
public class CustomUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 사용자 아이디 패스워드를 확인하는 로직이 들어 가야 함
		
		// 아이디 패스워드를 강제세팅
		return new User("user" , "1234" , new ArrayList<>());
	}
}
