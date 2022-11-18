package com.jbd.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/*******************************************************************************************************************************************************
 *   
 * Created By: @author Digvijay.Jatkar 
 * Description: This class is used to handle Global exception
 * Created Date: 17/11/2022
 * History:
 * Version	 Modified Date 		By 							Description 
 * 1.0 	     17/11/2022 	Digvijay.Jatkar    			This class is used to handle Global exception  
 * ***************************************************************************************************************************************************
 */
@Getter
@Setter
public class StudentManagementSystemException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;
	private Object object;

	public StudentManagementSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentManagementSystemException(String message) {
		super(message);
	}

	public StudentManagementSystemException(String message, HttpStatus statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public StudentManagementSystemException(String message, HttpStatus statusCode, Object object) {
		super(message);
		this.statusCode = statusCode;
		this.object = object;
	}

}