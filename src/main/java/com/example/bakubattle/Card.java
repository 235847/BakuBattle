package com.example.bakubattle;

public class Card {

    private String name;
    private String type;
    private String description;
    private int value;
    private boolean sets_block;

    public Card(String n, String t, int val, boolean block){
        name = n;
        type = t;
        value = val;
        sets_block = block;
        switch (type) {
            case "transferSingle" -> description = "This ability transfers " + value + "g from your opponent to you.";
            case "transferArea" -> description = "This ability transfers " + value + "g from your opponents to you.";
            case "attackSingle" -> description = "This ability attacks your opponent and deals him " + value + "g.";
            case "attackArea" -> description = "This ability attacks your opponents and deals them " + value + "g.";
            case "hpBoostv1" -> description = "This ability gives you " + value + "g.";
            case "hpBoostv2" -> description = "This ability gives you " + value + "g.";
            case "blockHealFriend" -> description = "This ability gives your partner " + value + "g and sets block.";
            case "blockHealTeam" -> description = "This ability gives you and your partner " + value + "g and sets block.";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSets_block() {
        return sets_block;
    }

    public void setSets_block(boolean sets_block) {
        this.sets_block = sets_block;
    }
}

