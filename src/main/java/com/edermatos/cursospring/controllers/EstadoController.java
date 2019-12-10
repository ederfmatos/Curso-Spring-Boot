package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.Estado;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.EstadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController implements CrudController<Estado> {

    private final EstadoService service;

    public EstadoController(EstadoService service) {
        this.service = service;
    }

    @Override
    public List<Estado> findAll() {
        return service.findAll();
    }

    @Override
    public Estado findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public Estado create(Estado input) {
        return service.create(input);
    }

    @Override
    public Estado update(int id, Estado input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }

}
