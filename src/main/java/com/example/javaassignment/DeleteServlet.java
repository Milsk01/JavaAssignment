package com.example.javaassignment;

import com.example.javaassignment.entity.Participants;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "deleteServlet", value = "/delete-servlet")
public class DeleteServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int deletedRows = 0;

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Participants participant = entityManager.find(Participants.class, Integer.parseInt(id));
            entityManager.remove(participant);
            entityManager.getTransaction().commit();
            entityManager.close();
            deletedRows = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (deletedRows > 0) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
}
