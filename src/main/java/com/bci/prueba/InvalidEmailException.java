package com.bci.prueba;

class InvalidEmailException extends RuntimeException {

	  InvalidEmailException() {
	    super("{\"mensaje\":Email invalido }");
	  }
	}