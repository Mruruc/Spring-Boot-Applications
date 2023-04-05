package com.Mruruc;

import java.sql.*;
import java.util.Scanner;

public class Insert {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan=new Scanner(System.in);

        DatabaseConnection connection=new DatabaseConnection();
        Connection connect=connection.getConnection();

        String into="INSERT INTO Student (id, name, email)" +
                "VALUES(?,?,?)";


        PreparedStatement statement=connect.prepareStatement(into);

        System.out.println("Please enter Student id:");
        int id=scan.nextInt();
        statement.setInt(1,id);
        scan.nextLine();

        System.out.println("Please enter the Student name:");
        String name=scan.nextLine();
        statement.setString(2,name);

        System.out.println("Please enter the Student email:");
        String email= scan.nextLine();
        statement.setString(3,email);
        statement.executeUpdate();


        connect.close();

    }
}
