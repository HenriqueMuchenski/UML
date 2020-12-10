package com.umlspring.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umlspring.demo.domain.Categoria;
import com.umlspring.demo.services.CategoriaService;

// Definindo esta classe como um componente de controle.
@RestController
// Definindo a rota para acessar os metodos desta classe controladora.
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// @PathVariable é utilizado quando o valor da variável é passada diretamente na
	// URL.
	public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
		
		Categoria categoria = service.buscar(id);
		
		return ResponseEntity.ok().body(categoria);
	}

}
