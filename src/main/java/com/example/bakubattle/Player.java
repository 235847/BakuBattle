package com.example.bakubattle;

import java.util.ArrayList;

public class Player {

    private String name;
    private Domain domain;
    private Bakugan bakugan = null;

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
}
