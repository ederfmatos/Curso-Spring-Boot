package com.edermatos.cursospring;

import com.edermatos.cursospring.domain.CategoriaEntidade;
import com.edermatos.cursospring.domain.ProdutoEntidade;
import com.edermatos.cursospring.repositories.CategoriaRepository;
import com.edermatos.cursospring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CategoriaEntidade cat1 = new CategoriaEntidade(null, "Eletrodomésticos");
        CategoriaEntidade cat2 = new CategoriaEntidade(null, "Informatica");
        CategoriaEntidade cat3 = new CategoriaEntidade(null, "Escritório");

        ProdutoEntidade p1 = new ProdutoEntidade(null, "Microondas", 359.90);
        ProdutoEntidade p2 = new ProdutoEntidade(null, "Notebook", 3759.90);
        ProdutoEntidade p3 = new ProdutoEntidade(null, "Mouse", 29.90);
        ProdutoEntidade p4 = new ProdutoEntidade(null, "Impressora", 359.90);
        ProdutoEntidade p5 = new ProdutoEntidade(null, "Liquidificador", 89.80);

        cat1.getProdutos().addAll(Arrays.asList(p1, p5));
        cat2.getProdutos().addAll(Arrays.asList(p2, p3, p4));
        cat3.getProdutos().addAll(Arrays.asList(p1, p4));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat3));
        p2.getCategorias().addAll(Arrays.asList(cat2));
        p3.getCategorias().addAll(Arrays.asList(cat2));
        p4.getCategorias().addAll(Arrays.asList(cat2, cat3));
        p5.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
