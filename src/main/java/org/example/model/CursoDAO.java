package org.example.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class CursoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void cadastrar(Curso curso) {
        // Persiste o curso no banco de dados
        entityManager.persist(curso);
    }
}
