package com.example.demo.manage.jwt.domain;

/**
 *
 */
public class Jwt {

	private final String accessToken;
	private final String refreshToken;
	
	public Jwt(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	@Override
	public String toString() {
		return "Jwt [accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	}
	
}
