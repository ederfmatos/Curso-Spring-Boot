package com.edermatos.cursospring.services;

import com.edermatos.cursospring.domain.CidadeEntidade;
import com.edermatos.cursospring.domain.EstadoEntidade;
import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import com.edermatos.cursospring.interfaces.CrudService;
import com.edermatos.cursospring.repositories.CidadeRepository;
import com.edermatos.cursospring.repositories.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService implements CrudService<CidadeEntidade> {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CidadeEntidade> findAll() {
        return repository.findAll();
    }

    @Override
    public CidadeEntidade findOne(int id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada!"));
    }

    @Override
    public CidadeEntidade create(CidadeEntidade input) {
        return repository.save(input);
    }

    @Override
    public CidadeEntidade update(int id, CidadeEntidade input) {
        input.setId(id);
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada!"));
        return repository.save(input);
    }

    @Override
    public void remove(int id) {
        CidadeEntidade entidade = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada!"));
        repository.delete(entidade);
    }

}
