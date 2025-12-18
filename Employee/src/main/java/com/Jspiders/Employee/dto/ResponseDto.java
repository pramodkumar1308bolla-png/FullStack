package com.Jspiders.Employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
	private String message;
	private T body;
	private int status;

}
