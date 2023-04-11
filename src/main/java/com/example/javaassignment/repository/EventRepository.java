package com.example.javaassignment.repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EventRepository {
    public static List getValidEvents(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List event =entityManager.createQuery("Select e from Events e").getResultList();

        System.out.println(event);

        entityManager.close();
        entityManagerFactory.close();

        return event;
    }
}
