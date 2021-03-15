package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.UserAllredyPresentException;

@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(UserAllredyPresentException.class)
	public ResponseEntity<ErrorMessage> showUserPresentException(UserAllredyPresentException ex)
	{
		ErrorMessage obj=new ErrorMessage(HttpStatus.IM_USED.value(), "user allredy present");
		return new ResponseEntity<ErrorMessage>(obj,HttpStatus.IM_USED);
		
	}

}
