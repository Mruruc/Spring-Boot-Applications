package com.Mruruc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DELETE {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan=new Scanner(System.in);
        DatabaseConnection connection=new DatabaseConnection();
        Connection connect=connection.getConnection();

        String dlt="DELETE FROM Student " +
                "WHERE id=(?)";
        PreparedStatement statement=connect.prepareStatement(dlt);
        System.out.println("Enter Student id that you want to delete: ");
        int id=scan.nextInt();
        statement.setInt(1,id);

        if(statement.executeUpdate() == 1){
            System.out.println("Delete operation is Successful !");
        }

        connect.close();



    }
}
