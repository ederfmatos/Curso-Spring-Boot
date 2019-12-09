package com.edermatos.cursospring.repositories;

import com.edermatos.cursospring.domain.CidadeEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntidade, Integer> {
}
