package edu.utdallas.hack.buyforme.entities;

import java.net.URI;

import org.apache.http.client.entity.UrlEncodedFormEntity;

public class HttpPostEntity {
	private URI httpUrl;
	private UrlEncodedFormEntity httpFormEntity;
	
	public URI getHttpUrl() {
		return httpUrl;
	}
	public void setHttpUrl(URI httpUrl) {
		this.httpUrl = httpUrl;
	}
	public UrlEncodedFormEntity getHttpFormEntity() {
		return httpFormEntity;
	}
	public void setHttpFormEntity(UrlEncodedFormEntity httpFormEntity) {
		this.httpFormEntity = httpFormEntity;
	}	
}
