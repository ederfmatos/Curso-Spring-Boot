package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.Cliente;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements CrudController<Cliente> {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @Override
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @Override
    public Cliente findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public Cliente create(Cliente input) {
        return service.create(input);
    }

    @Override
    public Cliente update(int id, Cliente input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }
}
