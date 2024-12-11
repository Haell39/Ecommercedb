package com.ecommerceFICR.Model.clientes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste-unit");

    public void salvar(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public Cliente buscar(Integer id) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }
}
