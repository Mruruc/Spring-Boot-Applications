package com.Mruruc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan=new Scanner(System.in);
        DatabaseConnection connection=new DatabaseConnection();
        Connection conect=connection.getConnection();

        String update="UPDATE Student " +
                "SET id=(?),email=(?)" +
                "WHERE id=(?)";
        PreparedStatement statement=conect.prepareStatement(update);

        System.out.println("Enter the id of Student that you want to update: ");
        int id= scan.nextInt();
        statement.setInt(1,id);
        statement.setInt(3,id);
        scan.nextLine();
        System.out.println("Enter the new email:");
        String email= scan.nextLine();
        statement.setString(2,email);

        if( statement.executeUpdate()==1){
            System.out.println("Update Successful !");
        }


        conect.close();

    }
}
