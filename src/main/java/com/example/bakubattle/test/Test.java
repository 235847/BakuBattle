package com.example.bakubattle.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
//        Random generator = new Random();
//        System.out.println(generator.nextInt(2));
//        System.out.println(generator.nextInt(2));
//        System.out.println(generator.nextInt(2));
//        System.out.println(generator.nextInt(2));
//        System.out.println(generator.nextInt(2));
//        System.out.println(generator.nextInt(2));
//        System.out.println(generator.nextInt(2));

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM bakubattle WHERE bakubattle.bakuID BETWEEN 7 AND 12");     //passing our query through the statement
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
            statement.close();                                  //closing the conversation with database.
            connection.close();
        }catch (Exception e){
            System.out.println("Error: loading from database\n");
            e.printStackTrace();
        }
    }
}
