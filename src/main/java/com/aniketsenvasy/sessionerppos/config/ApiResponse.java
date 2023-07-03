package com.aniketsenvasy.sessionerppos.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	public boolean status;
	public String message;
	public Object response;
}
