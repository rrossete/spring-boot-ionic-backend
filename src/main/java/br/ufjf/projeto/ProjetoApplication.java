package br.ufjf.projeto;

import br.ufjf.projeto.domain.*;
import br.ufjf.projeto.domain.enums.EstadoPagamento;
import br.ufjf.projeto.domain.enums.TipoCliente;
import br.ufjf.projeto.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { //criado para instaciar os objetos na hora do start da aplicação

        Categoria categoria1 = new Categoria(null,"Informática");
        Categoria categoria2  = new Categoria(null,"Escritório");

        Produto produto1 = new Produto(null, "Computador", 2000.00);
        Produto produto2 = new Produto(null, "Impressora", 800.00);
        Produto produto3 = new Produto(null, "Mouse", 80.00);

        categoria1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));

        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));

        Estado estado1 = new Estado(null, "Minas Gerais");
        Estado estado2 = new Estado(null, "São Paulo");

        Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
        Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
        Cidade cidade3 = new Cidade(null, "Campinas", estado2);

        estado1.getCidades().addAll(Arrays.asList(cidade2,cidade3));
        estado2.getCidades().addAll(Arrays.asList(cidade1));


        categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
        estadoRepository.saveAll(Arrays.asList(estado1,estado2));
        cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));

        Cliente cliente1 = new Cliente(null,"Maria Silva", "maria@gmail.com", "111111111", TipoCliente.PESSOAFISICA);
        cliente1.getTelefones().addAll(Arrays.asList("32613627","985586988"));

        Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38202155",cidade1,cliente1 );
        Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "3820265",cidade2,cliente1 );

        cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));

        clienteRepository.saveAll(Arrays.asList(cliente1));
        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

        SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");

        Pedido pedido1 = new Pedido(null, dateFormat.parse("30/09/2017 10:32"),cliente1,endereco1);
        Pedido pedido2 = new Pedido(null, dateFormat.parse("10/10/2017 19:35"),cliente1,endereco2);

        PagamentoComCartao comCartao1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,pedido1,6);
        pedido1.setPagamento(comCartao1);

        PagamentoComBoleto comBoleto= new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,pedido2,null , dateFormat.parse("20/10/2017 00:00"));
        pedido2.setPagamento(comBoleto);

        cliente1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));

        pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
        pagamentoRepository.saveAll(Arrays.asList(comBoleto,comCartao1));

        ItemPedido itemPedido1 =  new ItemPedido(pedido1,produto1,0.00,1,2000.00);
        ItemPedido itemPedido2 =  new ItemPedido(pedido1,produto3,0.00,2,80.00);
        ItemPedido itemPedido3 =  new ItemPedido(pedido2,produto2,100.00,1,800.00);

        pedido1.getItens().addAll(Arrays.asList(itemPedido1,itemPedido2));
        pedido2.getItens().addAll(Arrays.asList(itemPedido3));

        produto1.getItens().addAll(Arrays.asList(itemPedido1));
        produto2.getItens().addAll(Arrays.asList(itemPedido3));
        produto3.getItens().addAll(Arrays.asList(itemPedido2));

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1,itemPedido2,itemPedido3));





    }
}
