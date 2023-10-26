package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.example.domain");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("START TRANSACTION");

        try {
            Team team = new Team();

            Member member = new Member();
            member.changeName("member");
            // member.join(team);

            em.persist(member);

            System.out.println(member.getId());

            tx.commit();
            System.out.println("COMMIT");
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            System.out.println("ROLLBACK");
        } finally {
            em.close();
        }

        emf.close();
    }
}