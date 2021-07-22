package com.codetec.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetec.curso.entities.Usuario;
import com.codetec.curso.services.UsuarioService;

@RestController
@RequestMapping(value =  "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;

	//método de teste, o tipo de resposta do entity é do tipo Usuario
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		//Usuario u = new Usuario(1L, "teste", "teste@teste.com", "85855252", "123");
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") Long id){
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
}
