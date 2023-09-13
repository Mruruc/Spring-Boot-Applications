package com.mruruc;


import java.sql.SQLException;

public class Main{
    private  Repo<Emp,Integer> repo;
    public Main(){
        this.repo=new Create<Emp,Integer>(Emp.class);
    }
    public static void main(String[] args) throws SQLException {
        Main main=new Main();
        Emp emp1=new Emp();
        emp1.setId(54);
        emp1.setName("Wafllo-Bombeloo");
        //main.repo.save(emp1);
      // System.out.println(main.repo.findById(12));
     //   main.repo.update(emp1,54);
        main.repo.delete(12);
        main.repo.closeEmf_Em();
    }
}
