package com.codetec.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetec.curso.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
