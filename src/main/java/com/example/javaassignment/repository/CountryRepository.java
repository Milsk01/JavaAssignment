package com.example.javaassignment.repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CountryRepository {
    public static List getValidEvents(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List countries =entityManager.createQuery("Select c from Countries c").getResultList();

        System.out.println(countries);

        entityManager.close();
        entityManagerFactory.close();

        return countries;
    }
}
