package com.Mruruc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

      DatabaseConnection connection=new DatabaseConnection();
        Connection connect=connection.getConnection();

        Statement statement=connect.createStatement();

        ResultSet resultSet=statement.executeQuery("SELECT * FROM student WHERE id=100 " +
                "ORDER BY name");

        while(resultSet.next()){
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("email"));
        }

     /*   List<Student> list=new ArrayList<>();
        while(resultSet.next()){
            list.add(new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email")));
        }
        System.out.println("ID     NAME                   EMAIL:");
        for(Student str: list){
            System.out.println(str.getId()+" : "+str.getName()+" :   "+str.getEmail());
        }*/

        connect.close();


    }
}