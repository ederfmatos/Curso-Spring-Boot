package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.CidadeEntidade;
import com.edermatos.cursospring.domain.EstadoEntidade;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.CidadeService;
import com.edermatos.cursospring.services.EstadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController implements CrudController<CidadeEntidade> {

    private final CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @Override
    public List<CidadeEntidade> findAll() {
        return service.findAll();
    }

    @Override
    public CidadeEntidade findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public CidadeEntidade create(CidadeEntidade input) {
        return service.create(input);
    }

    @Override
    public CidadeEntidade update(int id, CidadeEntidade input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }

}
