package com.example.bakubattle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertsIntoDatabase {

    private final static String QUERY_CREATE_TABLE = "CREATE TABLE bakugany(" +
            "  `bakuID` int(11) NOT NULL,\n" +
            "  `name` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `hp` int(11) DEFAULT NULL,\n" +
            "  `xp` double DEFAULT NULL,\n" +
            "  `transferSingle` int(11) DEFAULT NULL,\n" +
            "  `transferSingleName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `transferArea` int(11) DEFAULT NULL,\n" +
            "  `transferAreaName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `attackSingle` int(11) DEFAULT NULL,\n" +
            "  `attackSingleName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `attackArea` int(11) DEFAULT NULL,\n" +
            "  `attackAreaName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `hpBoostv1` int(11) DEFAULT NULL,\n" +
            "  `hpBoostv1Name` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `hpBoostv2` int(11) DEFAULT NULL,\n" +
            "  `hpBoostv2Name` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `blockHealFriend` int(11) DEFAULT NULL,\n" +
            "  `blockHealFriendName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,\n" +
            "  `blockHealTeam` int(11) DEFAULT NULL,\n" +
            "  `blockHealTeamName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;";

    private final static String QUERY_INSERT = " insert into bacard (bakuID, name, attack, hp, mana)"
            + " values (?, ?, ?, ?, ?)";


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
            int i = 1;
            int separator_index_before, separator_index_after;
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                separator_index_after = data.indexOf('|');
                String name = data.substring(0,separator_index_after);
                separator_index_before = separator_index_after + 1;
                separator_index_after = data.indexOf('|',separator_index_before);
                String attack = data.substring(separator_index_before,separator_index_after);
                separator_index_before = separator_index_after + 1;
                separator_index_after = data.indexOf('|',separator_index_before);
                String hp = data.substring(separator_index_before,separator_index_after);
                separator_index_before = separator_index_after + 1;
                String mana = data.substring(separator_index_before);
//                System.out.println(data+"\n");
                System.out.println(name+" "+Integer.parseInt(attack)+" "+Integer.parseInt(hp)+" "+Integer.parseInt(mana)+"\n");
                preparedStmt.setInt(1, i);
                preparedStmt.setString(2, name);
                preparedStmt.setInt(3,Integer.parseInt(attack));
                preparedStmt.setInt(4,Integer.parseInt(hp));
                preparedStmt.setInt(5,Integer.parseInt(mana));
                preparedStmt.execute();
                i++;
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
}

