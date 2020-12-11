package com.umlspring.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umlspring.demo.domain.Cliente;
import com.umlspring.demo.services.ClienteService;

// Definindo esta classe como um componente de controle.
@RestController
// Definindo a rota para acessar os metodos desta classe controladora.
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// @PathVariable é utilizado quando o valor da variável é passada diretamente na
	// URL.
	public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {

		Cliente cliente = service.buscar(id);

		return ResponseEntity.ok().body(cliente);
	}

}
