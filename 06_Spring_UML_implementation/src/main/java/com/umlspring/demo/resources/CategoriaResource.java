package com.umlspring.demo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Definindo esta classe como uma classe de controle
@RestController
// Definindo a rota para acessar os metodos desta classe controladora
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "teste categorias rest";
	}
}
