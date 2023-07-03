package com.aniketsenvasy.sessionerppos.exception;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {
	public ErrorDetails(java.util.Date date, String message2, String description) {
		// TODO Auto-generated constructor stub
	}
	private Date timestamp;
	private String message;
	private String details;
}
