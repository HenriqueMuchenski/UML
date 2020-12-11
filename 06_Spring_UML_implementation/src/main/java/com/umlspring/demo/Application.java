package com.umlspring.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.umlspring.demo.domain.Categoria;
import com.umlspring.demo.domain.Cidade;
import com.umlspring.demo.domain.Cliente;
import com.umlspring.demo.domain.Endereco;
import com.umlspring.demo.domain.Estado;
import com.umlspring.demo.domain.Produto;
import com.umlspring.demo.domain.enums.TipoCliente;
import com.umlspring.demo.repositories.CategoriaRepository;
import com.umlspring.demo.repositories.CidadeRepository;
import com.umlspring.demo.repositories.ClienteRepository;
import com.umlspring.demo.repositories.EnderecoRepository;
import com.umlspring.demo.repositories.EstadoRepository;
import com.umlspring.demo.repositories.ProdutoRepository;

// CommandLineRunner serve para conseguirmos adicionar métodos auxiliares
// ao aplicação ser inicializada.
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		////////////////////////////////////////////////////////////////////////////////////
		// Muitos(Categoria) x Muitos(Produto)
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		////////////////////////////////////////////////////////////////////////////////////
		// Um(Estado) x Muitos(Cidade)

		Estado est1 = new Estado(null, "MG");
		Estado est2 = new Estado(null, "SP");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		// Apenas adicionando os dados em memória.
		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		////////////////////////////////////////////////////////////////////////////////////
		// Um(Cliente) x Muitos(Enderecos)
		// Um(Cidade) x Muitos(Enderecos)

		Cliente cli1 = new Cliente(null, "Henrique", "muchenski.dev@gmail.com", "12345678912",
				TipoCliente.PESSOA_FISICA);

		cli1.getTelefone().addAll(Arrays.asList("41998896521", "4136965613"));

		Endereco e1 = new Endereco(null, "Rua A", 123, "Sobrado 6", "Centro", "15900852", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua B", 321, "Apartamento 26", "Jadrim", "32650284", cli1, c3);

		// Apenas adicionando os dados em memória.
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
