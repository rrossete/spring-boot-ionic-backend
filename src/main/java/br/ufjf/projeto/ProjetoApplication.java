package br.ufjf.projeto;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.domain.Produto;
import br.ufjf.projeto.repositories.CategoriaRepository;
import br.ufjf.projeto.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;
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


        categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
        
    }
}
