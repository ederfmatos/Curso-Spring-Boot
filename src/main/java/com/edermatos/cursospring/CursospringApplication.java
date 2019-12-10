package com.edermatos.cursospring;

import com.edermatos.cursospring.domain.*;
import com.edermatos.cursospring.enumerations.EstadoPagamento;
import com.edermatos.cursospring.enumerations.TipoCliente;
import com.edermatos.cursospring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;


    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Eletrodomésticos");
        Categoria cat2 = new Categoria(null, "Informatica");
        Categoria cat3 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Microondas", 359.90);
        Produto p2 = new Produto(null, "Notebook", 3759.90);
        Produto p3 = new Produto(null, "Mouse", 29.90);
        Produto p4 = new Produto(null, "Impressora", 359.90);
        Produto p5 = new Produto(null, "Liquidificador", 89.80);

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

        Estado e1 = new Estado(null, "São Paulo", "SP");
        Estado e2 = new Estado(null, "Rio de Janeiro", "RJ");

        Cidade c1 = new Cidade(null, "Guariba", e1);
        Cidade c2 = new Cidade(null, "Araraquara", e1);

        e1.getCidades().addAll(Arrays.asList(c1, c2));

        estadoRepository.saveAll(Arrays.asList(e1, e2));

        Cliente cli1 = new Cliente(null, "Eder Matos", "ederfmatos@gmail.com", "12345678910", TipoCliente.PESSOA_FISICA);
        Endereco end1 = new Endereco(null, "Josefina Vidoretti de Oliveira", 61, null, "Mario Cazeri", "14840000", cli1, c1);
        cli1.getEnderecos().add(end1);
        cli1.getTelefones().add("16999644153");

        clienteRepository.save(cli1);

        Pedido ped1 = new Pedido(null, LocalDate.now(), null, cli1, end1);

        PagamentoComCartao pagto1 = new PagamentoComCartao(null, EstadoPagamento.PENDETE, ped1, 6);
        ped1.setPagamento(pagto1);

        pedidoRepository.save(ped1);
        pagamentoRepository.save(pagto1);
    }
}
