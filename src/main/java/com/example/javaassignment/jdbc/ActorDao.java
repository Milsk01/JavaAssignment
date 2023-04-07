package com.example.javaassignment.jdbc;


import java.sql.*;

public class ActorDao {

    private static Connection connection;

    private static void initConnection() throws SQLException {
         connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sakila","root","12345");
    }

    public static Actor readActor() throws SQLException{
            Actor actorA = new Actor();
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM actor ")) {

                ResultSet resultSet = statement.executeQuery();

                if(resultSet.next()){
                    int actor_id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);

                    actorA.setActor_id(actor_id);
                    actorA.setFirst_name(firstName);
                    actorA.setLast_name(lastName);
                }
            }

            return actorA;
        }

}
