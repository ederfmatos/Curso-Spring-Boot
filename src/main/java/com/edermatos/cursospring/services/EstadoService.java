package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.EstadoEntidade;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements CrudService<EstadoEntidade> {

    private final EstadoRepository repository;

    public EstadoService(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoEntidade> findAll() {
        return repository.findAll();
    }

    @Override
    public EstadoEntidade findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado!"));
    }

    @Override
    public EstadoEntidade create(EstadoEntidade input) {
        return repository.save(input);
    }

    @Override
    public EstadoEntidade update(int id, EstadoEntidade input) {
        input.setId(id);
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado!"));
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        EstadoEntidade entidade = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado!"));
        repository.delete(entidade);
    }

}
