package com.example.demo.manage.exception.base;

import com.example.demo.manage.exception.enums.base.EnumBaseException;

/**
 * 공통 예외 클래스
 */
public class CommonException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final Exception e;
	private final EnumBaseException enumBaseException;
	private final String message;
	
	public CommonException(Exception e, EnumBaseException enumBaseException) {
		super();
		this.e = e;
		this.enumBaseException = enumBaseException;
		this.message = "";
	}
	
	public CommonException(Exception e, EnumBaseException enumBaseException, String message) {
		super();
		this.e = e;
		this.enumBaseException = enumBaseException;
		this.message = message;
	}

	public Exception getE() {
		return e;
	}

	public EnumBaseException getEnumBaseException() {
		return enumBaseException;
	}

	public String getMessage() {
		return message;
	}
	
}
