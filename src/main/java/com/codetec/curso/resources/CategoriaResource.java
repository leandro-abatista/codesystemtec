package com.codetec.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetec.curso.entities.Categoria;
import com.codetec.curso.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> categorias = service.findAll();
		return ResponseEntity.ok().body(categorias);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") Long id){
		Categoria cat = service.buscarPorId(id);
		return ResponseEntity.ok().body(cat);
	}
	
}
