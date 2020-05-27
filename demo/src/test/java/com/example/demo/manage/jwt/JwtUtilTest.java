package com.example.demo.manage.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.manage.exception.base.CommonException;
import com.example.demo.manage.jwt.JwtComponent.TOKEN_TYPE;
import com.example.demo.manage.jwt.domain.Jwt;

@SpringBootTest
public class JwtUtilTest {

	@Autowired
	private JwtComponent jwtUtil;
	
	@Test
	public void 토큰_TEST() throws InterruptedException, Exception {
		
		String username = "user";
		String password = "1234";
				
		UserDetails user = new User( username, password, new ArrayList<>());
		
		Jwt token = jwtUtil.makeJwt( user.getUsername(), user.getPassword());
		System.out.println( token);

		new Thread( () -> {
			
			String usernameByToken;
			
			try {
				usernameByToken = jwtUtil.extractUsername(token.getAccessToken(), TOKEN_TYPE.ACCESS_TOKEN);
				System.out.println(username);
				assertEquals(username, usernameByToken);
				
				Boolean validateToken = jwtUtil.validateToken(token.getAccessToken(), user, TOKEN_TYPE.ACCESS_TOKEN);
				System.out.println(validateToken);
				
				assertEquals( validateToken, true);
			} catch (CommonException e) {
				e.printStackTrace();
			}
		}).start();
		
		Thread.sleep(3000);
		
		new Thread( () -> {
			
			try {
				String usernameByToken = jwtUtil.extractUsername(token.getAccessToken(), TOKEN_TYPE.ACCESS_TOKEN);
				System.out.println(username);
				assertEquals(username, usernameByToken);
				
				Boolean validateToken = jwtUtil.validateToken(token.getAccessToken(), user, TOKEN_TYPE.ACCESS_TOKEN);
				System.out.println(validateToken);
				assertEquals( validateToken, false);
			} catch (CommonException e) {
				e.printStackTrace();
			}
		}).start();
		
		
		
		Thread.sleep(10000);
		
	}
}
