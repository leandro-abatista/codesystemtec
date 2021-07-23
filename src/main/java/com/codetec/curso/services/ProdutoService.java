package com.codetec.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetec.curso.entities.Produto;
import com.codetec.curso.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		Optional<Produto> produto = repository.findById(id);
		return produto.get();
	}
}
