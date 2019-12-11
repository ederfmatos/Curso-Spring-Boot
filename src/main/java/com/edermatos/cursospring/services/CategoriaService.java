package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.Categoria;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements CrudService<Categoria> {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Categoria findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
    }

    @Override
    public Categoria create(Categoria input) {
        return repository.save(input);
    }

    @Override
    public Categoria update(int id, Categoria input) {
        findOne(id);
        input.setId(id);
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        findOne(id);
        repository.deleteById(id);
    }

}
