package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.Cidade;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.CidadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController implements CrudController<Cidade> {

    private final CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @Override
    public List<Cidade> findAll() {
        return service.findAll();
    }

    @Override
    public Cidade findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public Cidade create(Cidade input) {
        return service.create(input);
    }

    @Override
    public Cidade update(int id, Cidade input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }

}
