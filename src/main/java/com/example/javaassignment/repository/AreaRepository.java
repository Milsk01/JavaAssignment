package com.example.javaassignment.repository;


import com.example.javaassignment.entity.Areas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.geom.Area;
import java.util.List;

public class AreaRepository {

    public static List getAreas(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Areas area = new Areas();

        area.setAreaName("Computer Vision");
        entityManager.getTransaction().begin();

        entityManager.persist(area);

        entityManager.getTransaction().commit();



        List areas =entityManager.createQuery("Select e from Areas e").getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return areas;
    }

    public static void main(String[] args) {
        AreaRepository.getAreas();
    }
}
