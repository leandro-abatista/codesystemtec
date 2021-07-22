package com.codetec.curso.repositories;

import com.codetec.curso.entities.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
