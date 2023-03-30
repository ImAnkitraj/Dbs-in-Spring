package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "2019ugcs001");
            System.out.println(conn.getSchema());
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}