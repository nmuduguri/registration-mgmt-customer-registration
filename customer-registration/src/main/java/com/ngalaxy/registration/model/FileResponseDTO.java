package com.ngalaxy.registration.model;

import lombok.Data;

//@Data
public class FileResponseDTO {

    public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	private String filename;
    private String contentType;
    private byte[] content;

  
}

