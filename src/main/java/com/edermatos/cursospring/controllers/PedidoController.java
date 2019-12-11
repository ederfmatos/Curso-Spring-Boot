package com.edermatos.cursospring.controllers;

import com.edermatos.cursospring.domain.Pedido;
import com.edermatos.cursospring.interfaces.CrudController;
import com.edermatos.cursospring.services.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController implements CrudController<Pedido> {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @Override
    public List<Pedido> findAll() {
        return service.findAll();
    }

    @Override
    public Pedido findOne(int id) {
        return service.findOne(id);
    }

    @Override
    public Pedido create(Pedido input) {
        return service.create(input);
    }

    @Override
    public Pedido update(int id, Pedido input) {
        return service.update(id, input);
    }

    @Override
    public void remove(int id) {
        service.remove(id);
    }
}
