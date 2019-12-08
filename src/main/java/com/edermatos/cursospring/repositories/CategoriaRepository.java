package com.edermatos.cursospring.repositories;

import com.edermatos.cursospring.domain.CategoriaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntidade, Integer> {
}
