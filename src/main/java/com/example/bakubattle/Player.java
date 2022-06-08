package com.example.bakubattle;

import java.util.ArrayList;

public class Player {

    private String name;
    private Domain domain;
    private Bakugan bakugan = null;
    private Deck deck = null;
    private ForbiddenCard forbidden_card = new ForbiddenCard();
    private OpenCard open_card = new OpenCard();

    public Player(String name) {
        this.name = name;
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

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public ForbiddenCard getForbidden_card() {
        return forbidden_card;
    }

    public void setForbidden_card(ForbiddenCard forbidden_card) {
        this.forbidden_card = forbidden_card;
    }

    public OpenCard getOpen_card() {
        return open_card;
    }

    public void setOpen_card(OpenCard open_card) {
        this.open_card = open_card;
    }

    public void initializeDeck(){
        if(deck == null){
            deck = new Deck(this,domain.isActive(),forbidden_card.isActive(),open_card.isActive());
        }
    }
}
