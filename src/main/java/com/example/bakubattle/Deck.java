package com.example.bakubattle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        try{
            deck = new ArrayList<>();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bacard");     //passing our query through the statement
            while (rs.next()){
                String name = rs.getString("name");
                int attack = rs.getInt("attack");
                int hp = rs.getInt("hp");
                int mana = rs.getInt("mana");
                deck.add(new Card(name,attack,hp,mana));
            }
            statement.close();          //closing the conversation with database.
            connection.close();             //optional
        }catch (Exception e){
            System.out.println("Error: loading from database\n");
            e.printStackTrace();
        }
    };

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        return deck.remove(deck.size() - 1);
    }

    public Card drawCard(int id) {
        return deck.remove(id);
    }

    public void testDiplayDeck() {
        System.out.println("I want to see my first card:");
        System.out.println("Name:"+deck.get(0).getName());
        System.out.println("Attack:"+deck.get(0).getAttack());
        System.out.println("Hp:"+deck.get(0).getHp());
        System.out.println("Mana:"+deck.get(0).getMana_cost());
    }
}
