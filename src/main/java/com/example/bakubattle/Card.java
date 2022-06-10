package com.example.bakubattle;

public class Card {

    private String name;
    private String type;
    private String description;
    private int value;
    private boolean sets_block;

    public Card(String n, String t, int val, boolean block){
        name = n;
        value = val;
        sets_block = block;
        switch (t) {
            case "transferSingle" ->{
                type = "transfer-single";
                description = "This ability transfers " + value + "g from your opponent to you.";
            }
            case "transferArea" ->{
                type = "transfer-area";
                description = "This ability transfers " + value + "g from your opponents to you.";
            }
            case "attackSingle" ->{
                type = "attack-single";
                description = "This ability attacks your opponent and deals him " + value + "g.";
            }
            case "attackArea" ->{
                type = "attack-area";
                description = "This ability attacks your opponents and deals them " + value + "g.";
            }
            case "hpBoostv1", "hpBoostv2" ->{
                type = "hp-boost";
                description = "This ability gives you " + value + "g.";
            }
            case "blockHealFriend" ->{
                type = "block-heal friend";
                description = "This ability gives your partner " + value + "g and sets block.";
            }
            case "blockHealTeam" ->{
                type = "block-heal team";
                description = "This ability gives you and your partner " + value + "g and sets block.";
            }
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

