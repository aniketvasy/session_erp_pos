package com.aniketsenvasy.sessionerppos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class DataNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DataNotFound(String message){
		super(message);
}

}
