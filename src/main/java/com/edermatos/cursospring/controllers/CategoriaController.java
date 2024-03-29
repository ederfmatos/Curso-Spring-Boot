package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.Categoria;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController implements CrudController<Categoria> {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @Override
    public List<Categoria> findAll() {
        return service.findAll();
    }

    @Override
    public Categoria findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public Categoria create(Categoria input) {
        return service.create(input);
    }

    @Override
    public Categoria update(int id, Categoria input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }

}