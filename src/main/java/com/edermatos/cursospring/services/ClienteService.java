package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.Cliente;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements CrudService<Cliente> {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Cliente findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
    }

    @Override
    public Cliente create(Cliente input) {
        return repository.save(input);
    }

    @Override
    public Cliente update(int id, Cliente input) {
        input.setId(id);
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!"));
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
