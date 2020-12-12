package com.umlspring.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umlspring.demo.domain.Pedido;
import com.umlspring.demo.repositories.PedidoRepository;
import com.umlspring.demo.services.exceptions.ObjectNotFoundException;

// Definindo esta classe como um componente de serviço.
@Service
public class PedidoService {

	// Injeção de dependência.
	@Autowired
	private PedidoRepository repository;

	public Pedido buscar(Integer id) {

		Optional<Pedido> pedido = repository.findById(id);

		// Retornando uma exceção para o controlador, caso pedido retorne null.
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
