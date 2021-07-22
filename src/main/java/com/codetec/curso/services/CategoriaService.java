package com.codetec.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetec.curso.entities.Categoria;
import com.codetec.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria buscarPorId(Long id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.get();
	}
}
