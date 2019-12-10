package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.Cidade;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService implements CrudService<Cidade> {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cidade> findAll() {
        return repository.findAll();
    }

    @Override
    public Cidade findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada!"));
    }

    @Override
    public Cidade create(Cidade input) {
        return repository.save(input);
    }

    @Override
    public Cidade update(int id, Cidade input) {
        input.setId(id);
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada!"));
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        Cidade entidade = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada!"));
        repository.delete(entidade);
    }

}
