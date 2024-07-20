package com.dynamic_json_editor.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionErrorResponse {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
}
