package com.example.bakubattle;

public class Team {

    private Player player1;
    private Player player2;
    public int sum_hp = 0;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getSumHp() {
        return sum_hp;
    }

    public void setSumHp(int sum_hp) {
        this.sum_hp = sum_hp;
    }
}
