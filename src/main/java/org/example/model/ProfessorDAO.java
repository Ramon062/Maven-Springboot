package org.example.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class ProfessorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void cadastrar(Professor professor) {
        // Persiste o professor no banco de dados
        entityManager.persist(professor);
    }
}
