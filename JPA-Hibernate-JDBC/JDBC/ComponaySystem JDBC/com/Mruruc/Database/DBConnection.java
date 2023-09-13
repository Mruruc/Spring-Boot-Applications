package com.Mruruc.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String url="jdbc:postgresql://localhost:5432/Company";
    private final String username="postgres";
    private final String password="word";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection manager=DriverManager.getConnection(url,username,password);
        return   manager;
    }
}
