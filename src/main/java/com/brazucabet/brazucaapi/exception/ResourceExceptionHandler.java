package com.brazucabet.brazucaapi.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.net.HttpHeaders;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(BadRequestException.class) //400
	public ResponseEntity<StandardError> badRequestException(BadRequestException e, HttpServletRequest httpServletrequest){
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardError(
				HttpStatus.BAD_REQUEST, 
				e.getMessage(),
				httpServletrequest.getRequestURI()));
	}
	
	
	@ExceptionHandler(UnathorizedException.class) //401
	public ResponseEntity<StandardError> unathorizedException(UnathorizedException e, HttpServletRequest httpServletrequest){
		
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new StandardError(
				HttpStatus.UNAUTHORIZED, 
				e.getMessage(),
				httpServletrequest.getRequestURI()));
	}
	
	@ExceptionHandler(Forbidden.class) //403
	public ResponseEntity<StandardError> forbiddenException(Forbidden e, HttpServletRequest httpServletrequest){
		
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new StandardError(
				HttpStatus.FORBIDDEN, 
				e.getMessage(),
				httpServletrequest.getRequestURI()));
	}
	
	
	@ExceptionHandler(NotFoundException.class) //403
	public ResponseEntity<StandardError> notFoundException(NotFoundException e, HttpServletRequest httpServletrequest){
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandardError(
				HttpStatus.NOT_FOUND, 
				e.getMessage(),
				httpServletrequest.getRequestURI()));
	}
	

	@ExceptionHandler(InternalServerError.class) //403
	public ResponseEntity<StandardError> InternalServerErrorException(InternalServerError e, HttpServletRequest httpServletrequest){
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StandardError(
				HttpStatus.INTERNAL_SERVER_ERROR, 
				e.getMessage(),
				httpServletrequest.getRequestURI()));
	}
	
	
	@ExceptionHandler(RuntimeException.class) //403
	public ResponseEntity<StandardError> runtimeException(RuntimeException e, HttpServletRequest httpServletrequest){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StandardError(
				HttpStatus.INTERNAL_SERVER_ERROR, 
				e.getMessage(),
				httpServletrequest.getRequestURI()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handlerException(Exception e, Object body, HttpStatus httpStatus, 
			HttpHeaders httpHeaders, WebRequest request){
		
		
		return ResponseEntity.status(httpStatus).body(new StandardError(
				httpStatus, e.getMessage(), request.getContextPath()));
	}
	
	
	
	
	
	
	
	
	
	
	
}
