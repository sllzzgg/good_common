package com.dshl.commons.exception;

import org.slf4j.Logger;

import com.dshl.commons.pojo.ResponseHeader;

/**
 * Service异常
 * 
 * @author zhouguojun
 *
 */
public class ServiceException extends BaseException {

	/**  */
	private static final long serialVersionUID = -7458153543156179397L;

	public ServiceException(int errorCode, String message) {
		super(errorCode, message);
	}

	public ServiceException() {
		super("service");
		this.errorCode = ResponseHeader.Status.BAD_RESPONSE;
	}

	public ServiceException(String message) {
		super(message);
		this.errorCode = ResponseHeader.Status.BAD_RESPONSE;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	protected ServiceException(int errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(Exception e, Logger log) {
		super(e, log);
	}

}
