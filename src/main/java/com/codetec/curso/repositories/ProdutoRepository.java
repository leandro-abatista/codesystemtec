package com.codetec.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetec.curso.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
