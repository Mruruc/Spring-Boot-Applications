package com.Mruruc.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        DBConnection connection=new DBConnection();
        Connection connection1 = connection.getConnection();

        connection1.close();
    }
}
