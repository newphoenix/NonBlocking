package com.example.deferred;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.dto.UserDto;
import com.example.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@Slf4j
public class UserDeferred<T> extends DeferredResult<ResponseEntity<UserDto>> implements Runnable {
	
	private Integer id;
	private UserService userService;

	@Override
	public void run() {
		
		long t1 = System.currentTimeMillis();
		
		try {
			ResponseEntity<UserDto> result = ResponseEntity.ok(userService.getUserById(id));
			this.setResult(result);
			
		} catch (Exception e) {
			this.setErrorResult(e);
		}
		
		
		long t2 = System.currentTimeMillis();
		
		log.info("""
				Execution time: {} ms."
				""", //
				(t2 - t1));

	}

}
