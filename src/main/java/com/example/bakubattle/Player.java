package com.example.bakubattle;

import java.util.ArrayList;

public class Player {

    enum choice{
        attack,
        card_manage
    }

    private int current_mana;
    private int starting_mana;
    private int hp;
    private final static int STARTING_HP = 30;
    choice status;
    private ArrayList<Card> player_deck;

    public Player(Card first) {
        hp = STARTING_HP;
        starting_mana = 1;
        current_mana = starting_mana;
        status = choice.card_manage;
        player_deck = new ArrayList<>(3);
        player_deck.add(first);
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Card> getPlayer_deck() {
        return player_deck;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCurrent_mana() {
        return current_mana;
    }
}
