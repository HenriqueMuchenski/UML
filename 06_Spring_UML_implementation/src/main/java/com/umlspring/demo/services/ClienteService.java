package com.umlspring.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umlspring.demo.domain.Cliente;
import com.umlspring.demo.repositories.ClienteRepository;
import com.umlspring.demo.services.exceptions.ObjectNotFoundException;

// Definindo esta classe como um componente de serviço.
@Service
public class ClienteService {

	// Injeção de dependência.
	@Autowired
	private ClienteRepository repository;

	public Cliente buscar(Integer id) {

		Optional<Cliente> Cliente = repository.findById(id);

		// Retornando uma exceção para o controlador, caso Cliente retorne null.
		return Cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
