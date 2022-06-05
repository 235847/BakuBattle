package com.example.bakubattle;

public class PassingClass {

    private Team teamA;
    private Team teamB;
    private String who_select;
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
}
