package com.example.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.aop.MeasureTime;
import com.example.deferred.UserDeferred;
import com.example.dto.UserDto;
import com.example.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

	@Qualifier("demoTaskExecutor")
	private TaskExecutor executor;
	private UserService userService;

	@MeasureTime
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {

		return ResponseEntity.ok(userService.getUserById(id));

	}

	@MeasureTime
	@GetMapping("defer/{id}")
	public DeferredResult<ResponseEntity<UserDto>> getUserByIdDefer(@PathVariable Integer id) {

		final UserDeferred<ResponseEntity<UserDto>> deferredResult = new UserDeferred<>(id, userService);

		executor.execute(deferredResult);
		return deferredResult;

	}

}
