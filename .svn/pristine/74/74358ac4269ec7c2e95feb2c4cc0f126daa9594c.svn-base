package com.dshl.commons.exception;

import org.slf4j.Logger;

/**
 * Exception 基类
 * 
 * @author zhouguojun
 */
public class BaseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int errorCode;

	public BaseException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	protected BaseException() {
		super();
	}

	protected BaseException(String message) {
		super(message);
	}

	protected BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	protected BaseException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	protected BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(Exception e, Logger log) {
		super(e);
		StackTraceElement[] ste = e.getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append(e.getMessage() + "\r\n");
		for (int i = 0; i < ste.length; i++) {
			sb.append(ste[i].toString() + "\r\n");
		}
		log.error(sb.toString());
	}

	public int getErrorCode() {
		return errorCode;
	}
}
