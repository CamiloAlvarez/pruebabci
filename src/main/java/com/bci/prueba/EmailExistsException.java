package com.bci.prueba;

class EmailExistsException extends RuntimeException {

	  EmailExistsException() {
	    super("{\"mensaje\":El correo ya existe }");
	  }
	}