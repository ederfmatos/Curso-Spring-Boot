package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.ClienteEntidade;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements CrudController<ClienteEntidade> {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @Override
    public List<ClienteEntidade> findAll() {
        return service.findAll();
    }

    @Override
    public ClienteEntidade findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public ClienteEntidade create(ClienteEntidade input) {
        return service.create(input);
    }

    @Override
    public ClienteEntidade update(int id, ClienteEntidade input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }
}
