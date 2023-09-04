package com.bci.prueba;

class UserNotFoundException extends RuntimeException {

	  UserNotFoundException(Long id) {
	    super("{\"mensaje\":El usuario "+id+" no existe}");
	  }
	}