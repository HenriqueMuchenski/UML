package com.umlspring.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umlspring.demo.domain.Categoria;
import com.umlspring.demo.repositories.CategoriaRepository;

// Definindo esta classe como um componente de serviço.
@Service
public class CategoriaService {
	
	// Injeção de dependência.
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria =	repository.findById(id);
		return categoria.orElse(null);
	}
}
