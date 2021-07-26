package com.codetec.curso.services.exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super("Violação de restrição de integridade referencial! Não pode excluir este usuário!" + msg);
	}

}
