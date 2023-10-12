package com.mruruc;

import java.util.Date;

/**
 *important  Project Lombok Annotations.
 *
 */
public class App 
{
    public static void main( String[] args ) {


        User user1=new User("Waflo","Mafloo","waflo.pl-12334@gmail.com",
                new Date(),"+4895221320",Gender.MALE,"waflo_maflo_122132");
     //   System.out.println(user1);

        User user2=new User();
        user2.setFirst_name("Neloo");
        user2.setLast_name("Bombelo");
        user2.setDate_of_birth(new Date(2050-2-12));
        user2.setGender(Gender.FEMALE);
        user2.setEmail("nelo_bombelo@gmail.com");
        user2.setPassword("nelo__bombelo123");

        System.out.println(user2);
    }
}
