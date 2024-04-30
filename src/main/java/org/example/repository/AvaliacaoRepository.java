package org.example.repository;


import org.example.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository
        extends JpaRepository<Avaliacao, Integer> {
}
