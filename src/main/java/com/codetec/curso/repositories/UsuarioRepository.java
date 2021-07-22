package com.codetec.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetec.curso.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
