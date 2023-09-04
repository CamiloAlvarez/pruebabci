package com.bci.prueba;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<Usuario,Long> {

	List<Usuario> findByEmail(String email);
}