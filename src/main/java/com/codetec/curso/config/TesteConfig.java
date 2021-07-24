package com.codetec.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.codetec.curso.entities.Categoria;
import com.codetec.curso.entities.ItemPedido;
import com.codetec.curso.entities.Pedido;
import com.codetec.curso.entities.Produto;
import com.codetec.curso.entities.Usuario;
import com.codetec.curso.entities.enums.StatusPedido;
import com.codetec.curso.repositories.CategoriaRepository;
import com.codetec.curso.repositories.ItemPedidoRepository;
import com.codetec.curso.repositories.PedidoRepository;
import com.codetec.curso.repositories.ProdutoRepository;
import com.codetec.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PedidoRepository pedidorepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		produto1.getCategorias().add(cat2);//associaçõa entre objtos
		produto2.getCategorias().add(cat1);
		produto2.getCategorias().add(cat3);
		produto3.getCategorias().add(cat3);
		produto4.getCategorias().add(cat3);
		produto5.getCategorias().add(cat2);
		
		//salvando as associações
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		repository.saveAll(Arrays.asList(u1, u2));
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2021-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2021-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO,u2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2021-07-21T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO,u1);
		
		pedidorepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 2, produto1.getPreco());
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 1, produto3.getPreco());
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto3, 2, produto3.getPreco());
		ItemPedido itemPedido4 = new ItemPedido(pedido3, produto5, 2, produto5.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3, itemPedido4));
	}
	
	
}
