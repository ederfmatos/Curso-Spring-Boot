package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.Estado;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements CrudService<Estado> {

    private final EstadoRepository repository;

    public EstadoService(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estado> findAll() {
        return repository.findAll();
    }

    @Override
    public Estado findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado!"));
    }

    @Override
    public Estado create(Estado input) {
        return repository.save(input);
    }

    @Override
    public Estado update(int id, Estado input) {
        input.setId(id);
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado!"));
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        Estado entidade = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado!"));
        repository.delete(entidade);
    }

}
