package com.dshl.commons.exception;

import com.dshl.commons.pojo.ResponseHeader;

/**
 * 请求响应异常类
 * 
 * @author zhouguojun
 *
 */
public class ResponseException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 718917705302719682L;

	public ResponseException(int errorCode, String message) {
		super(errorCode, message);
	}

	public ResponseException() {
		super("Bad Response");
		this.errorCode = ResponseHeader.Status.BAD_RESPONSE;
	}

	public ResponseException(String message) {
		super(message);
		this.errorCode = ResponseHeader.Status.BAD_RESPONSE;
	}

	public ResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResponseException(Throwable cause) {
		super(cause);
	}
}
