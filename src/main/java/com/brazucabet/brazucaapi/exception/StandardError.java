package com.brazucabet.brazucaapi.exception;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError(HttpStatus httpStatus, String message, String Path) {
		super();
		
		this.status = httpStatus.value();
		this.error = httpStatus.name();
		this.timeStamp = new Date().getTime();
		this.message = message;
		this.path = path;
		
	}
}
