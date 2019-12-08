package com.edermatos.cursospring.interfaces;

import java.util.List;

public interface CrudService<E> {

    List<E> findAll();

    E findOne(int id);

    E create(E input);

    E update(int id, E input);

    void remove(int id);

}
