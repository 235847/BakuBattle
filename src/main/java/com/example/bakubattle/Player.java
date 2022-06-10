package com.example.bakubattle;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private Domain domain;
    private Bakugan bakugan = null;
    private Deck deck = null;
    private ForbiddenCard forbidden_card = new ForbiddenCard();
    private OpenCard open_card = new OpenCard();
    private boolean is_dead;
    private boolean not_killed;

    public Player(String name) {
        is_dead = false;
        not_killed = true;
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

    public void kill() {
        is_dead = true;
        bakugan.setBlock(true);
        not_killed = false;
    }

    public boolean isDead(){
        return is_dead;
    }

    public void useCard(Team team_to_attack, Team team_to_support, Card card, String my_name) {
        Random generator = new Random();
        int x = generator.nextInt(2);
        switch(card.getType()){
            case "transfer-single" -> handleTransferSingle(team_to_attack,team_to_support,card,my_name, x);
            case "transfer-area" -> handleTransferArea(team_to_attack,team_to_support,card,my_name);
            case "attack-single" -> handleAttackSingle(team_to_attack,team_to_support,my_name, card, x);
            case "attack-area" -> handleAttackArea(team_to_attack,team_to_support,my_name, card);
            case "hp-boost" -> handleHpBoost(team_to_support, card, my_name);
            case "block-heal friend" -> handleBlockHealFriend(team_to_support, card, my_name);
            case "block-heal team" -> handleBlockHealTeam(team_to_support, card, my_name);
        }
    }

    private void handleBlockHealTeam(Team team_to_support, Card card, String my_name) {
        if(team_to_support.getPlayer1().getName().equals(my_name)){
            if(card.getValue() == -2){
                team_to_support.getPlayer2().getBakugan().doubleHp_positive();
                team_to_support.getPlayer1().getBakugan().doubleHp_positive();
            }
            else{
                team_to_support.getPlayer2().getBakugan().addHp(card.getValue());
                team_to_support.getPlayer1().getBakugan().addHp(card.getValue());
            }
            team_to_support.getPlayer1().getBakugan().setBlock(true);
            team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.01);
        }
        else{
            if(card.getValue() == -2){
                team_to_support.getPlayer1().getBakugan().doubleHp_positive();
                team_to_support.getPlayer2().getBakugan().doubleHp_positive();
            }
            else{
                team_to_support.getPlayer1().getBakugan().addHp(card.getValue());
                team_to_support.getPlayer2().getBakugan().addHp(card.getValue());
            }
            team_to_support.getPlayer2().getBakugan().setBlock(true);
            team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.01);
        }
    }

    private void handleBlockHealFriend(Team team_to_support, Card card, String my_name) {
        if(team_to_support.getPlayer1().getName().equals(my_name)){
            if(card.getValue() == -2){
                team_to_support.getPlayer2().getBakugan().doubleHp_positive();
            }
            else{
                team_to_support.getPlayer2().getBakugan().addHp(card.getValue());
            }
            team_to_support.getPlayer1().getBakugan().setBlock(true);
            team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.02);
        }
        else{
            if(card.getValue() == -2){
                team_to_support.getPlayer1().getBakugan().doubleHp_positive();
            }
            else{
                team_to_support.getPlayer1().getBakugan().addHp(card.getValue());
            }
            team_to_support.getPlayer2().getBakugan().setBlock(true);
            team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.02);
        }
    }

    private void handleHpBoost(Team team_to_support, Card card, String my_name) {
        if(team_to_support.getPlayer1().getName().equals(my_name)){
            if(card.getValue() == -2){
                team_to_support.getPlayer1().getBakugan().doubleHp_positive();
            }
            else{
                team_to_support.getPlayer1().getBakugan().addHp(card.getValue());
            }
            team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.03);
        }
        else{
            if(card.getValue() == -2){
                team_to_support.getPlayer2().getBakugan().doubleHp_positive();
            }
            else{
                team_to_support.getPlayer2().getBakugan().addHp(card.getValue());
            }
            team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.03);
        }
    }

    private void handleAttackArea(Team team_to_attack,Team team_to_support, String my_name, Card card) {
        if(card.getValue() == -2){
            if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                team_to_attack.getPlayer1().getBakugan().doubleHp_negative();
            }
            else{
                team_to_attack.getPlayer1().getBakugan().setBlock(false);
            }
            if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                team_to_attack.getPlayer2().getBakugan().doubleHp_negative();
            }
            else{
                team_to_attack.getPlayer2().getBakugan().setBlock(false);
            }
        }
        else{
            if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                team_to_attack.getPlayer1().getBakugan().subtractHp(card.getValue());
            }
            else{
                team_to_attack.getPlayer1().getBakugan().setBlock(false);
            }
            if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                team_to_attack.getPlayer2().getBakugan().subtractHp(card.getValue());
            }
            else{
                team_to_attack.getPlayer2().getBakugan().setBlock(false);
            }
        }

        if(team_to_support.getPlayer1().getName().equals(my_name)){
            team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.05);
        }
        else{
            team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.05);
        }
    }

    private void handleAttackSingle(Team team_to_attack, Team team_to_support, String my_name, Card card, int n) {
        if(n == 0){
            if(card.getValue() == -2){
                if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                    team_to_attack.getPlayer1().getBakugan().doubleHp_negative();
                }
                else{
                    team_to_attack.getPlayer1().getBakugan().setBlock(false);
                }
            }
            else{
                if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                    team_to_attack.getPlayer1().getBakugan().subtractHp(card.getValue());
                }
                else{
                    team_to_attack.getPlayer1().getBakugan().setBlock(false);
                }
            }
        }
        else {
            if(card.getValue() == -2){
                if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                    team_to_attack.getPlayer2().getBakugan().doubleHp_negative();
                }
                else{
                    team_to_attack.getPlayer2().getBakugan().setBlock(false);
                }
            }
            else{
                if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                    team_to_attack.getPlayer2().getBakugan().subtractHp(card.getValue());
                }
                else{
                    team_to_attack.getPlayer2().getBakugan().setBlock(false);
                }
            }
        }

        if(team_to_support.getPlayer1().getName().equals(my_name)){
            team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.04);
        }
        else{
            team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.04);
        }
    }

    private void handleTransferArea(Team team_to_attack, Team team_to_support, Card card, String my_name) {
        int success_attack = 0;
        if(card.getValue() == -2){
            if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                team_to_attack.getPlayer1().getBakugan().doubleHp_negative();
                success_attack++;
            }
            else{
                if(!team_to_attack.getPlayer1().isDead()){
                    team_to_attack.getPlayer1().getBakugan().setBlock(false);
                }
            }
            if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                team_to_attack.getPlayer2().getBakugan().doubleHp_negative();
                success_attack++;
            }
            else{
               if(!team_to_attack.getPlayer2().isDead()){
                    team_to_attack.getPlayer2().getBakugan().setBlock(false);
               }
            }
            if(team_to_support.getPlayer1().getName().equals(my_name)){
                if(success_attack == 2){
                    team_to_support.getPlayer1().getBakugan().doubleHp_positive();
                }
                team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.07);
            }
            else{
                if(success_attack == 2){
                    team_to_support.getPlayer2().getBakugan().doubleHp_positive();
                }
                team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.07);
            }
        }
        else{
            if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                team_to_attack.getPlayer1().getBakugan().subtractHp(card.getValue());
                success_attack++;
            }
            else{
                if(!team_to_attack.getPlayer1().isDead()){
                    team_to_attack.getPlayer1().getBakugan().setBlock(false);
                }
            }
            if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                team_to_attack.getPlayer2().getBakugan().subtractHp(card.getValue());
                success_attack++;
            }
            else{
                if(!team_to_attack.getPlayer2().isDead()){
                    team_to_attack.getPlayer2().getBakugan().setBlock(false);
                }
            }
            if(team_to_support.getPlayer1().getName().equals(my_name)){
                if(success_attack == 2){
                    team_to_support.getPlayer1().getBakugan().addHp(card.getValue()*2);
                }
                else if(success_attack == 1){
                    team_to_support.getPlayer1().getBakugan().addHp(card.getValue());
                }
                team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.07);
            }
            else{
                if(success_attack == 2){
                    team_to_support.getPlayer2().getBakugan().addHp(card.getValue()*2);
                }
                else if(success_attack == 1){
                    team_to_support.getPlayer2().getBakugan().addHp(card.getValue());
                }
                team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.07);
            }
        }
    }

    private void handleTransferSingle(Team team_to_attack, Team team_to_support, Card card, String my_name,int n){
        int success_attack = 0;
        if(n == 0){
            if(card.getValue() == -2){
                if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                    team_to_attack.getPlayer1().getBakugan().doubleHp_negative();
                    success_attack++;
                }
                else{
                    if(!team_to_attack.getPlayer1().isDead()){
                        team_to_attack.getPlayer1().getBakugan().setBlock(false);
                    }
                }
                if(team_to_support.getPlayer1().getName().equals(my_name)){
                    if(success_attack == 1){
                        team_to_support.getPlayer1().getBakugan().doubleHp_positive();
                    }
                    team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.06);
                }
                else{
                    if(success_attack == 1){
                        team_to_support.getPlayer2().getBakugan().doubleHp_positive();
                    }
                    team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.06);
                }
            }
            else{
                if(!team_to_attack.getPlayer1().getBakugan().isBlock()){
                    team_to_attack.getPlayer1().getBakugan().subtractHp(card.getValue());
                    success_attack++;
                }
                else{
                   if(!team_to_attack.getPlayer1().isDead()){
                        team_to_attack.getPlayer1().getBakugan().setBlock(false);
                    }
                }
                if(team_to_support.getPlayer1().getName().equals(my_name)){
                    if(success_attack == 1){
                        team_to_support.getPlayer1().getBakugan().addHp(card.getValue());
                    }
                    team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.06);
                }
                else{
                    if(success_attack == 1){
                        team_to_support.getPlayer2().getBakugan().addHp(card.getValue());
                    }
                    team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.06);
                }
            }
        }
        else {
            if(card.getValue() == -2){
                if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                    team_to_attack.getPlayer2().getBakugan().doubleHp_negative();
                    success_attack++;
                }
                else{
                    if(!team_to_attack.getPlayer2().isDead()){
                        team_to_attack.getPlayer2().getBakugan().setBlock(false);
                    }
                }
                if(team_to_support.getPlayer1().getName().equals(my_name)){
                    if(success_attack == 1){
                        team_to_support.getPlayer1().getBakugan().doubleHp_positive();
                    }
                    team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.06);
                }
                else{
                    if(success_attack == 1){
                        team_to_support.getPlayer2().getBakugan().doubleHp_positive();
                    }
                    team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.06);
                }
            }
            else{
                if(!team_to_attack.getPlayer2().getBakugan().isBlock()){
                    team_to_attack.getPlayer2().getBakugan().subtractHp(card.getValue());
                    success_attack++;
                }
                else{
                    if(!team_to_attack.getPlayer2().isDead()){
                        team_to_attack.getPlayer2().getBakugan().setBlock(false);
                    }
                }
                if(team_to_support.getPlayer1().getName().equals(my_name)){
                    if(success_attack == 1){
                        team_to_support.getPlayer1().getBakugan().addHp(card.getValue());
                    }
                    team_to_support.getPlayer1().getBakugan().addXp(team_to_support.getPlayer1().getBakugan().getXP_MULTIPLIER()-0.06);
                }
                else{
                    if(success_attack == 1){
                        team_to_support.getPlayer2().getBakugan().addHp(card.getValue());
                    }
                    team_to_support.getPlayer2().getBakugan().addXp(team_to_support.getPlayer2().getBakugan().getXP_MULTIPLIER()-0.06);
                }
            }
        }
    }

    public boolean killed() {
        return !not_killed;
    }
}
