package org.example.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class PessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void cadastrar(Pessoa pessoa) {
        // Persiste a pessoa no banco de dados
        entityManager.persist(pessoa);
    }
}
