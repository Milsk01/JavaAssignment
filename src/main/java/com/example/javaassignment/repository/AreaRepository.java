package com.example.javaassignment.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AreaRepository {

    public static List getAreas(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        List areas =entityManager.createQuery("Select a from Areas a").getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return areas;
    }

    public static void main(String[] args) {
        AreaRepository.getAreas();
    }
}
