package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.Pedido;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements CrudService<Pedido> {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @Override
    public Pedido findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado"));
    }

    @Override
    public Pedido create(Pedido input) {
        return repository.save(input);
    }

    @Override
    public Pedido update(int id, Pedido input) {
        findOne(id);
        input.setId(id);
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
