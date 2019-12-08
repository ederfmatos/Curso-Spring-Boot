package com.edermatos.cursospring.repositories;

import com.edermatos.cursospring.domain.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntidade, Integer> {
}
