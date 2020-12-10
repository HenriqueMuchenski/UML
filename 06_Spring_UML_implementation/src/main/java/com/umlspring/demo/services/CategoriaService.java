package com.umlspring.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umlspring.demo.domain.Categoria;
import com.umlspring.demo.repositories.CategoriaRepository;
import com.umlspring.demo.services.exceptions.ObjectNotFoundException;

// Definindo esta classe como um componente de serviço.
@Service
public class CategoriaService {

	// Injeção de dependência.
	@Autowired
	private CategoriaRepository repository;

	public Categoria buscar(Integer id) {

		Optional<Categoria> categoria = repository.findById(id);

		// Retornando uma exceção para o controlador, caso categoria retorne null.
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ", Tipo: " + categoria.getClass().getName()));
	}
}
