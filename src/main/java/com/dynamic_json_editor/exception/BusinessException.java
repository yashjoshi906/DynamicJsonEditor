package com.dynamic_json_editor.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super("Resource Not Found On Server !!");
	}

	public BusinessException(String message) {
		super(message);
	}

}
