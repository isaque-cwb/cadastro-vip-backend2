package com.isaqueLourenco.cadastroVip.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	
	private List<FieldMessageException> list = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, long timeStamp) {
		super(status, msg, timeStamp);
		
	}

	public List<FieldMessageException> getErrors() {
		return list;
	}

	public void addError(String fieldName, String message) {
		list.add(new FieldMessageException(fieldName, message));
	}

}
