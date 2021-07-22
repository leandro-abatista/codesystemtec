package com.codetec.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetec.curso.entities.Pedido;
import com.codetec.curso.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.get();
	}
}
