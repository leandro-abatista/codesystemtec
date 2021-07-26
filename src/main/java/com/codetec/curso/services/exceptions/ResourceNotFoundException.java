package com.codetec.curso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Recebe como parâmetro o id, caso não encontre o id, será lançada a excessão
	 * @param id
	 */
	public ResourceNotFoundException(Object id) {
		super("Recurso não encontrado para o id :: " + id);
	}

}
