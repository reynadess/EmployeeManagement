package in.reynadess.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.reynadess.exception.EmployeeErrorResponse;
import in.reynadess.exception.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(ResourceNotFoundException error) {
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
		
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(error.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception error) {
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
		
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(error.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}		
}
