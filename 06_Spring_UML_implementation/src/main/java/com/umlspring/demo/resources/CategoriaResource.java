package com.umlspring.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umlspring.demo.domain.Categoria;

// Definindo esta classe como uma classe de controle
@RestController
// Definindo a rota para acessar os metodos desta classe controladora
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		
		List<Categoria> categorias = Arrays.asList(
				new Categoria(1 ,"teste1"), 
				new Categoria(2, "teste2"));
		
		return categorias;
	}
}
