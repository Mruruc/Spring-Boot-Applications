package com.Mruruc;

import java.sql.*;

public class DatabaseConnection{
    private String url="jdbc:postgresql://localhost:5432/Example1";
    private String username="postgres";
    private String password="word";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,username,password);
    }


}
