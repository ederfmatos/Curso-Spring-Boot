package com.edermatos.cursospring;

import com.edermatos.cursospring.domain.CategoriaEntidade;
import com.edermatos.cursospring.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CategoriaEntidade cat1 = new CategoriaEntidade(null, "Eletrodomésticos");
        CategoriaEntidade cat2 = new CategoriaEntidade(null, "Informatica");
        CategoriaEntidade cat3 = new CategoriaEntidade(null, "Escritório");
        CategoriaEntidade cat4 = new CategoriaEntidade(null, "Cama Mesa e Banho");
        CategoriaEntidade cat5 = new CategoriaEntidade(null, "Jardinagem");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
    }
}
