package com.Mruruc.Application;

import com.Mruruc.Database.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan=new Scanner(System.in);
        DBConnection connection=new DBConnection();
        Connection connection1= connection.getConnection();
        PreparedStatement preparedStatement=null;
        Statement statement;
        ResultSet resultSet;


        while(true){
            System.out.println("If you want add employee enter 1:");
            System.out.println("if you want to read employee list enter 2:");
            System.out.println("if you want to update an employee enter 3: ");
            System.out.println("if you want to delete an employee enter 4:");
            System.out.println("if you want to exit enter 5:");
            int choice=scan.nextInt();
            switch (choice){
                case 1:
                    String into="INSERT INTO System " +
                            "VALUES(?,?,?,?) ";
                    preparedStatement=connection1.prepareStatement(into);
                    System.out.println("Please enter the Employee id:");
                    int id=scan.nextInt();
                    preparedStatement.setInt(1,id);
                    scan.nextLine();
                    System.out.println("Please enter the employee First Name:");
                    String fname=scan.nextLine();
                    preparedStatement.setString(2,fname);
                    System.out.println("Please enter the employee Last Name:");
                    String lname=scan.nextLine();
                    preparedStatement.setString(3,lname);
                    System.out.println("Please enter the employee email:");
                    String email=scan.nextLine();
                    preparedStatement.setString(4,email);
                    if(preparedStatement.executeUpdate()==1){
                        System.out.println("Successful !");
                    }
                    else{
                        System.out.println("Try again !");
                    }

                    break;
                case 2:
                    System.out.println("===================================================");
                    statement=connection1.createStatement();
                    resultSet=statement.executeQuery("SELECT * FROM System");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt("id")+" "+ resultSet.getString("fName")+
                                " "+resultSet.getString("lName")+"  "+resultSet.getString("email"));
                    }
                    System.out.println("===================================================");
                    break;
                case 3:

                    String update="UPDATE System1 " +
                            "SET id=(?),email=(?)" +
                            "WHERE id=(?)";
                    preparedStatement=connection1.prepareStatement(update);
                    System.out.println("Enter the id of employee:");
                    int id3= scan.nextInt();
                    preparedStatement.setInt(1,id3);
                    preparedStatement.setInt(3,id3);
                    scan.nextLine();
                    System.out.println("Enter the new email: ");
                    String newEmail= scan.nextLine();
                    preparedStatement.setString(2,newEmail);
                    preparedStatement.executeUpdate();
                    break;
                case 4:
                    System.out.println("Enter the employee id that you want to delete:");
                    int id1= scan.nextInt();
                    String dlt=" DELETE FROM System WHERE id=(?)";
                    preparedStatement=connection1.prepareStatement(dlt);
                    preparedStatement.setInt(1,id1);
                    preparedStatement.executeUpdate();
                    break;

                case 5:
                    System.out.println("Good Bye !");
                    connection1.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice !");

            }
        }
    }
}
