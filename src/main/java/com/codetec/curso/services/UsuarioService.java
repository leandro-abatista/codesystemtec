package com.codetec.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetec.curso.entities.Usuario;
import com.codetec.curso.repositories.UsuarioRepository;
import com.codetec.curso.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario cadastrar(Usuario usuario) {
		return repository.save(usuario);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		//deixa o objeto monitorado e prepara para fazer qualquer ação com o objto
		Usuario entity = repository.getOne(id);
		atualizarDados(entity, usuario);
		return repository.save(entity);
	}

	private void atualizarDados(Usuario entity, Usuario usuario) {
		entity.setNome(usuario.getNome());
		entity.setEmail(usuario.getEmail());
		entity.setFone(usuario.getFone());
	}
}
