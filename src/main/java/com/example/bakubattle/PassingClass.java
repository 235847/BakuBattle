package com.example.bakubattle;

public class PassingClass {

    private Team teamA;
    private Team teamB;
    private String who_select;
    private boolean player1A_strategy;
    private boolean player2A_strategy;
    private boolean player1B_strategy;
    private boolean player2B_strategy;
    private final static PassingClass PASSER = new PassingClass();


    private PassingClass(){}

    public static PassingClass getInstance(){
        return PASSER;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public String getWho_select() {
        return who_select;
    }

    public void setWho_select(String who_select) {
        this.who_select = who_select;
    }

    public void setPlayer1AStrategy(boolean player1A_strategy) {
        this.player1A_strategy = player1A_strategy;
    }

    public void setPlayer2AStrategy(boolean player2A_strategy) {
        this.player2A_strategy = player2A_strategy;
    }

    public void setPlayer1BStrategy(boolean player1B_strategy) {
        this.player1B_strategy = player1B_strategy;
    }

    public void setPlayer2BStrategy(boolean player2B_strategy) {
        this.player2B_strategy = player2B_strategy;
    }

    public boolean isStrategySet(){
        return player1A_strategy && player2A_strategy && player1B_strategy && player2B_strategy;
    }
}
