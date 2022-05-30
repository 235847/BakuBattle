package com.example.bakubattle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertsIntoDatabase {

    private final static String QUERY_CREATE_TABLE = "CREATE TABLE bakubattle (" +
            "bakuID int NOT NULL," +
            "name varchar(100) NOT NULL" +
            "hp int NOT NULL," +
            "xp double NOT NULL," +
            "transferSingle int NOT NULL," +
            "transferSingleName varchar(100) NOT NULL," +
            "transferArea int NOT NULL," +
            "transferAreaName varchar(100) NOT NULL," +
            "attackSingle int NOT NULL," +
            "attackSingleName varchar(100) NOT NULL," +
            "attackArea int NOT NULL," +
            "attackAreaName varchar(100) NOT NULL," +
            "hpBoostv1 int NOT NULL," +
            "hpBoostv1Name varchar(100) NOT NULL," +
            "hpBoostv2 int NOT NULL," +
            "hpBoostv2Name varchar(100) NOT NULL," +
            "blockHealFriend int NOT NULL," +
            "blockHealFriendName varchar(100) NOT NULL," +
            "blockHealTeam int NOT NULL," +
            "blockHealTeamName varchar(100) NOT NULL," +
            "PRIMARY KEY (bakuID))";

    private final static String QUERY_INSERT = "INSERT INTO bakugany (bakuID, name, hp, xp, transferSingle, transferSingleName, transferArea, transferAreaName, attackSingle, attackSingleName, attackArea, attackAreaName, hpBoostv1, hpBoostv1Name, hpBoostv2, hpBoostv2Name, blockHealFriend, blockHealFriendName, blockHealTeam, blockHealTeamName)"
            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static int separator_index_after;

    /**
     * @description
     * {
     *     To load this database we need to download the XAMPP package and set default settings during an installation process.
     *     Then we are required to start the application and click "START" for APACHE and MYSQL.
     *     Last but not least, we must enter the phpmyadmin by writing in our browser: localhost/phpmyadmin/ (enter).
     * }
     * @section CREATE CONNECTION - explanation:
     * {
     *     jdbc:mysql:// - means we want to activate jdbc with mysql.
     *     localhost/ - our database is set on our computer.
     *     bakugan - name of database.
     *     root - by default the user is named as root.
     *     "" - no password protection.
     * }
     * @section CREATE TABLE - creating table bacard.
     * @section INSERTING - we want to insert data from the file into bacard table.
     */
    public static void main(String[] args) {
        try{
            /*CREATE CONNECTION*/
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bakugan","root","");     //establishing connection with database

            /*CREATE TABLE*/
            PreparedStatement prepareStatement_for_creating = connection.prepareStatement(QUERY_CREATE_TABLE);
            prepareStatement_for_creating.executeUpdate();
            prepareStatement_for_creating.close();      //closing the statement.

            /*INSERTING*/
            PreparedStatement preparedStmt = connection.prepareStatement(QUERY_INSERT);
            File fp = new File("inserts");
            Scanner scanner = new Scanner(fp);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();

                separator_index_after = data.indexOf('|');
                String bakuID = data.substring(0,separator_index_after);
                String name = extract(data);
                String hp = extract(data);
                String xp = extract(data);
                String value1 = extract(data);
                String value1_name = extract(data);
                String value2 = extract(data);
                String value2_name = extract(data);
                String value3 = extract(data);
                String value3_name = extract(data);
                String value4 = extract(data);
                String value4_name = extract(data);
                String value5 = extract(data);
                String value5_name = extract(data);
                String value6 = extract(data);
                String value6_name = extract(data);
                String value7 = extract(data);
                String value7_name = extract(data);
                String value8 = extract(data);
                String value8_name = data.substring(separator_index_after+1);

                System.out.println(data+"\n");
                System.out.println(bakuID+" "+name+" "+xp+" "+value1+" "+value1_name+" "+value2+" "+value2_name+" "+value3+" "+value3_name+" "+value4+" "+value4_name+" "+value5+" "+value5_name+" "+value6+" "+value6_name+" "+value7+" "+value7_name+" "+value8+" "+value8_name+"\n");
                preparedStmt.setInt(1, Integer.parseInt(bakuID));
                preparedStmt.setString(2, name);
                preparedStmt.setInt(3, Integer.parseInt(hp));
                preparedStmt.setDouble(4, Double.parseDouble(xp));
                preparedStmt.setInt(5, Integer.parseInt(value1));
                preparedStmt.setString(6, value1_name);
                preparedStmt.setInt(7, Integer.parseInt(value2));
                preparedStmt.setString(8, value2_name);
                preparedStmt.setInt(9, Integer.parseInt(value3));
                preparedStmt.setString(10, value3_name);
                preparedStmt.setInt(11, Integer.parseInt(value4));
                preparedStmt.setString(12, value4_name);
                preparedStmt.setInt(13, Integer.parseInt(value5));
                preparedStmt.setString(14, value5_name);
                preparedStmt.setInt(15, Integer.parseInt(value6));
                preparedStmt.setString(16, value6_name);
                preparedStmt.setInt(17, Integer.parseInt(value7));
                preparedStmt.setString(17, value7_name);
                preparedStmt.setInt(18, Integer.parseInt(value8));
                preparedStmt.setString(19, value8_name);
                preparedStmt.execute();
            }
            scanner.close();
            preparedStmt.close();
            connection.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: couldn't open the file");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error: writing into database");
        }
    }


    private static String extract(String data){
        int separator_index_before = separator_index_after+1;
        separator_index_after = data.indexOf('|',separator_index_before);
        return data.substring(separator_index_before,separator_index_after);
    }
}

