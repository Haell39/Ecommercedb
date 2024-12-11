package com.ecommerceFICR.Model.clientes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {
    private EntityManager entityManager;

    public ClienteDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Teste-unit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void create(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente find(int id) {
        return entityManager.find(Cliente.class, id);
    }

    public void update(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    public void delete(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }

    public void closeEntityManager() {
        entityManager.close();
    }
}
