package com.dshl.commons.exception;

import com.dshl.commons.pojo.ResponseHeader;

/**
 * 请求参数异常类
 * 
 * @author zhouguojun
 *
 */
public class RequestException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4062199957776024564L;

	public RequestException(int errorCode, String message) {
		super(errorCode, message);
	}

	public RequestException() {
		super("Bad Request");
		this.errorCode = ResponseHeader.Status.BAD_REQUEST;
	}

	public RequestException(String message) {
		super(message);
		this.errorCode = ResponseHeader.Status.BAD_REQUEST;
	}

	public RequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestException(Throwable cause) {
		super(cause);
	}
}
