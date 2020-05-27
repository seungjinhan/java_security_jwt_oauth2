package com.example.demo.manage.security;

import com.example.demo.manage.jwt.domain.Jwt;

/**
 * 인증처리후 반환값
 */
public class AuthenticationResponse {

	private Jwt jwt;

	public AuthenticationResponse(Jwt jwt) {
		super();
		this.jwt = jwt;
	}

	public Jwt getJwt() {
		return jwt;
	}

	public void setJwt(Jwt jwt) {
		this.jwt = jwt;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + "]";
	}
	
	
}
