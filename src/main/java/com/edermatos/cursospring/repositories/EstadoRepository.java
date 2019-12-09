package com.edermatos.cursospring.repositories;

import com.edermatos.cursospring.domain.EstadoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntidade, Integer> {
}
