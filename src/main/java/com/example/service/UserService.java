package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.example.dto.UserDto;
import com.example.exception.UserNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private static final String URL = "https://jsonplaceholder.typicode.com/users/";

	private RestTemplate restTemplate;

	public UserDto getUserById(Integer id) {

		try {
			
			return restTemplate.getForEntity(URL + id, UserDto.class).getBody();
		} catch (HttpStatusCodeException e) {
			throw new UserNotFoundException(e.getMessage());
		}

	}

}
