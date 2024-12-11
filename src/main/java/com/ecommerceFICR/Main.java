package com.ecommerceFICR;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste-unit");
        EntityManager em = emf.createEntityManager();

        System.out.println("Conexão bem-sucedida!");

        em.close();
        emf.close();
    }
}
