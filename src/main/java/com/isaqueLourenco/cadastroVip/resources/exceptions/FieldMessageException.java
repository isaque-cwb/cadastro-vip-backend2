package com.isaqueLourenco.cadastroVip.resources.exceptions;

import java.io.Serializable;

public class FieldMessageException implements Serializable{
	private static final long serialVersionUID = 1L;
		
	private String fieldName;
	private String message;
	
	public FieldMessageException() {}

	public FieldMessageException(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFiledName() {
		return fieldName;
	}

	public void setFieldName(String fieldname) {
		this.fieldName = fieldname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
