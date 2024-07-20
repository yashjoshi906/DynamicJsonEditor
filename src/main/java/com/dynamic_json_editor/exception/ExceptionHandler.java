package com.dynamic_json_editor.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {
			BusinessException.class
	})
	public Map<String, String> inputException(BusinessException ex) {
		Map<String, String> errMap = new HashMap<>();
		errMap.put("errorMessage", ex.getMessage());
		return errMap;
	}
}
