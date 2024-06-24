package io.hexlet;

import io.hexlet.dao.UserDAO;
import io.hexlet.model.User;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Application {

    public static void main(String[] args) throws SQLException {

        try (var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet_test")) {

            var dao = new UserDAO(conn);

            var user = new User("Maria", "888888888");

            System.out.println(user.getId());
            dao.save(user);
            System.out.println(user.getId());


            var user2 = dao.find(user.getId()).get();
            System.out.println(user2);
            dao.delete(user.getId());
        }
    }
}