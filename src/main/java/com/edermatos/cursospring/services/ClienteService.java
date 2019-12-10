package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.ClienteEntidade;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements CrudService<ClienteEntidade> {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClienteEntidade> findAll() {
        return repository.findAll();
    }

    @Override
    public ClienteEntidade findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
    }

    @Override
    public ClienteEntidade create(ClienteEntidade input) {
        return repository.save(input);
    }

    @Override
    public ClienteEntidade update(int id, ClienteEntidade input) {
        input.setId(id);
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!"));
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
