package com.example.bakubattle;

public class Card {

    private String name;
    private String type;
    private String description;
    private int value;

    public Card(String n, String t, int val){
        name = n;
        type = t;
        value = val;
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
}

