package com.dshl.commons.exception;

import org.slf4j.Logger;

import com.dshl.commons.pojo.ResponseHeader;

/**
 * 
 * DAO异常
 * 
 * @author zhouguojun
 *
 */
public class DaoException extends BaseException {

	/**  */
	private static final long serialVersionUID = -7458153543156179397L;

	public DaoException(int errorCode, String message) {
		super(errorCode, message);
	}

	public DaoException() {
		super("DAO");
		this.errorCode = ResponseHeader.Status.SQL_ERROR;
	}

	public DaoException(String message) {
		super(message);
		this.errorCode = ResponseHeader.Status.SQL_ERROR;
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	protected DaoException(int errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(Exception e, Logger log) {
		super(e, log);
	}

}
