package com.learn.spring.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class RequestDetails {
	private String url;
	private HttpMethod requestType;
	private HttpHeaders httpHeaders;
	
	public RequestDetails(String url, HttpMethod requestType, HttpHeaders httpHeaders) {
		super();
		this.url = url;
		this.requestType = requestType;
		this.httpHeaders = httpHeaders;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HttpMethod getRequestType() {
		return requestType;
	}
	public void setRequestType(HttpMethod requestType) {
		this.requestType = requestType;
	}
	
	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}
	@Override
	public String toString() {
		return "RequestDetails [url=" + url + ", requestType=" + requestType + ", httpHeaders=" + httpHeaders + "]";
	}
	
}
