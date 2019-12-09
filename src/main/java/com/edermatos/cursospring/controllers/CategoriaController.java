package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.CategoriaEntidade;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController implements CrudController<CategoriaEntidade> {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @Override
    public List<CategoriaEntidade> findAll() {
        return service.findAll();
    }

    @Override
    public CategoriaEntidade findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public CategoriaEntidade create(CategoriaEntidade input) {
        return service.create(input);
    }

    @Override
    public CategoriaEntidade update(int id, CategoriaEntidade input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }

}