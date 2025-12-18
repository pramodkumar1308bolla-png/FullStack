package com.JspidersSecurity.serviceImpl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.JspidersSecurity.service.jwtService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class jwtServiceImpl implements jwtService {
	
	private static final String secret =
	        "3s9F5z4x9XQb6+WlKJkQx1s8C0oYqFZq8HcM2nK5pLs=";


	@Override
	public String generateTocken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return createTocken(claims, userName);
	}

	private String createTocken(Map<String, Object> claims, String userName) {
		// TODO Auto-generated method stub
		return Jwts.builder().claims(claims).subject(userName).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + (100 * 60 * 30))).signWith(getSignKey()).compact();
	}

	private Key getSignKey() {
		// TODO Auto-generated method stub

		byte[] keyBytes=Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
