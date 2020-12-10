package com.umlspring.demo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.umlspring.demo.services.exceptions.ObjectNotFoundException;

//Esta classe Handler intercepta e lança respostas de exceções adequadas para o corpo da requisição.

//Definindo esta classe como um componente de manipulação de controladores.
@ControllerAdvice
public class ResourceExceptionHandler {

	// Definindo que este método é um tratador de exceções.
	// @ExceptionHandler(<Exceção que o método irá tratar>.class)
	@ExceptionHandler(ObjectNotFoundException.class)
	// HttpServletRequest obtém as informações da requisição realizada.
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
