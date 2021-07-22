package com.codetec.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetec.curso.entities.Usuario;

@RestController
@RequestMapping(value =  "/usuarios")
public class UsuarioResource {

	//método de teste, o tipo de resposta do entity é do tipo Usuario
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "teste", "teste@teste.com", "85855252", "123");
		
		return ResponseEntity.ok().body(u);
	}
}
