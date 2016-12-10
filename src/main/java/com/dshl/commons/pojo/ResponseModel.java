package com.dshl.commons.pojo;


import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * 
 * @author: tony
 */
public class ResponseModel {
	@Resource
	public ResponseHeader responseHeader;
	public Object data;

	public ResponseModel() {
	}

	public ResponseModel(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

}
