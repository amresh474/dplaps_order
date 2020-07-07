package com.dpl.order.config;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Praveen K T
 *
 */

@Getter
@Setter
public class Response<T> {
	private String statusCode = "10000";
	private boolean status = false;
	private String msg = "FAILURE";
	private int httpCode = 404;

	private T data = null;

	public Response(Map<String, ?> codes, int httpCode, T data) {
		this.statusCode = codes.get("statusCode") != null ? codes.get("statusCode").toString() : "10000";
		this.status = codes.get("status") != null ? Boolean.parseBoolean(codes.get("status").toString()) : Boolean.FALSE;
		this.msg = codes.get("msg") != null ? codes.get("msg").toString() : "FAILURE";
		this.httpCode = httpCode >= 200 ? httpCode : 404;
		this.data = data;
	}

	public Response(Map<String, ?> codes, int httpCode) {
		this.statusCode = codes.get("statusCode") != null ? codes.get("statusCode").toString() : "10000";
		this.status = codes.get("status") != null ? Boolean.parseBoolean(codes.get("status").toString()) : Boolean.FALSE;
		this.msg = codes.get("msg") != null ? codes.get("msg").toString() : "FAILURE";
		this.httpCode = httpCode >= 200 ? httpCode : 404;
		this.data = null;
	}
	
	public Response(int httpCode, T data) {
		this.status=true;
		this.msg="SUCCESS";
		this.httpCode = httpCode >= 200 ? httpCode : 404;
		this.data = data;
	}

	public Response() {
	}

}
