package com.umlspring.demo;

import java.text.SimpleDateFormat;
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
import com.umlspring.demo.domain.ItemPedido;
import com.umlspring.demo.domain.Pagamento;
import com.umlspring.demo.domain.PagamentoComBoleto;
import com.umlspring.demo.domain.PagamentoComCartao;
import com.umlspring.demo.domain.Pedido;
import com.umlspring.demo.domain.Produto;
import com.umlspring.demo.domain.enums.EstadoPagamento;
import com.umlspring.demo.domain.enums.TipoCliente;
import com.umlspring.demo.repositories.CategoriaRepository;
import com.umlspring.demo.repositories.CidadeRepository;
import com.umlspring.demo.repositories.ClienteRepository;
import com.umlspring.demo.repositories.EnderecoRepository;
import com.umlspring.demo.repositories.EstadoRepository;
import com.umlspring.demo.repositories.ItemPedidoRepository;
import com.umlspring.demo.repositories.PagamentoRepository;
import com.umlspring.demo.repositories.PedidoRepository;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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

		// Apenas adicionando os dados em memória.
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		// Como o JoinTable entre Produto x Categoria está na classe Produto
		// Adicionar a Categoria ao Produto sim irá resultar em inserções
		// no banco de dados.

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

		////////////////////////////////////////////////////////////////////////////////////
		// Um(Pedido) x Um(Pagamento)
		// Um(Cliente) x Muitos(Pedidos)
		// Um(Endereco) x Muitos(Pedidos)

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("20/06/2020 18:32"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		// Setando o pedido ao pagamento(para que seja possível possuirem o mesmo id).
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		// Setando o pedido ao pagamento(para que seja possível possuirem o mesmo id).
		ped2.setPagamento(pagto2);

		// Apenas adicionando os dados em memória.
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		////////////////////////////////////////////////////////////////////////////////////

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 200.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().add(ip3);

		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
