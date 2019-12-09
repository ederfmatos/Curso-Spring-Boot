package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.EstadoEntidade;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.EstadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController implements CrudController<EstadoEntidade> {

    private final EstadoService service;

    public EstadoController(EstadoService service) {
        this.service = service;
    }

    @Override
    public List<EstadoEntidade> findAll() {
        return service.findAll();
    }

    @Override
    public EstadoEntidade findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public EstadoEntidade create(EstadoEntidade input) {
        return service.create(input);
    }

    @Override
    public EstadoEntidade update(int id, EstadoEntidade input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }

}
