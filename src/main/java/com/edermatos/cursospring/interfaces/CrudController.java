package com.edermatos.cursospring.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface CrudController<E> {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<E> findAll();

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    E findOne(@PathVariable int id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    E create(@RequestBody E input);

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    E update(@PathVariable int id, @RequestBody E input);

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void remove(@PathVariable int id);

}
