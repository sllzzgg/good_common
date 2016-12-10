package com.dshl.commons.pojo;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created with IntelliJ IDEA.
 * 
 * @author tony
 */
public class ResponseHeader {
	public class Status {
		public static final int OK = 200;
		public static final int BAD_REQUEST = 400;
		public static final int NOT_LOGIN = 433; // 未登录
		public static final int REQUEST_PARAM_ERROR = 434; // 请求参数错误
		public static final int UNSUPPORTED_REQUEST = 450;
		public static final int BAD_RESPONSE = 510; // 返回结果集错误
		public static final int SQL_ERROR = 511; // 执行SQL或查询数据库错误

		public static final int INTERNAL_ERROR = 500; // 服务内部错误
	}

	protected long time = System.currentTimeMillis();
	protected String message = "success";
	protected int code = Status.OK;

	@Value("#{configProperties['server.version']}")
	protected String version;

	public ResponseHeader() {
	}

	public ResponseHeader(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public long getTime() {
		return this.time;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
