package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.CategoriaEntidade;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements CrudService<CategoriaEntidade> {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaEntidade> findAll() {
        return repository.findAll();
    }

    @Override
    public CategoriaEntidade findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
    }

    @Override
    public CategoriaEntidade create(CategoriaEntidade input) {
        return repository.save(input);
    }

    @Override
    public CategoriaEntidade update(int id, CategoriaEntidade input) {
        input.setId(id);
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        CategoriaEntidade entidade = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
        repository.delete(entidade);
    }

}
