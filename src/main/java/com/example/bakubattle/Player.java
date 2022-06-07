package com.example.bakubattle;

import java.util.ArrayList;

public class Player {

    private String name;
    private Domain domain;
    private Bakugan bakugan = null;
    private Deck deck;
    private ForbiddenCard forbidden_card = new ForbiddenCard();
    private OpenCard open_card = new OpenCard();

    public Player(String text){
        name = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Bakugan getBakugan() {
        return bakugan;
    }

    public void setBakugan(Bakugan bakugan) {
        this.bakugan = bakugan;
    }

    public ForbiddenCard getForbidden_card() {
        return forbidden_card;
    }

    public OpenCard getOpen_card() {
        return open_card;
    }

    public void initializeDeck(){
        deck = new Deck(this,domain.isActive(),forbidden_card.isActive(),open_card.isActive());
    }
}
