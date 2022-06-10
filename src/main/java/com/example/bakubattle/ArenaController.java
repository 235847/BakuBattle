package com.example.bakubattle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    /* Player 1A attributes */
    @FXML
    private ImageView player1A_imageview;
    @FXML
    private  ProgressBar player1A_hp_bar;
    @FXML
    private Label player1A_hp;
    @FXML
    private ProgressBar player1A_xp_bar;
    @FXML
    private  Label player1A_xp;
    @FXML
    private ImageView player1A_deck;

    /* Player 2A attributes */
    @FXML
    private ImageView player2A_imageview;
    @FXML
    private  ProgressBar player2A_hp_bar;
    @FXML
    private  Label player2A_hp;
    @FXML
    private ProgressBar player2A_xp_bar;
    @FXML
    private  Label player2A_xp;
    @FXML
    private ImageView player2A_deck;

    /* Player 1B attributes */
    @FXML
    private ImageView player1B_imageview;
    @FXML
    private  ProgressBar player1B_hp_bar;
    @FXML
    private  Label player1B_hp;
    @FXML
    private ProgressBar player1B_xp_bar;
    @FXML
    private  Label player1B_xp;
    @FXML
    private ImageView player1B_deck;

    /* Player 2B attributes */
    @FXML
    private ImageView player2B_imageview;
    @FXML
    private  ProgressBar player2B_hp_bar;
    @FXML
    private  Label player2B_hp;
    @FXML
    private ProgressBar player2B_xp_bar;
    @FXML
    private  Label player2B_xp;
    @FXML
    private ImageView player2B_deck;

    /* Stategy attributes */
    @FXML
    private Label enter_label;
    @FXML
    private Button first_card_button;
    @FXML
    private Button second_card_button;
    @FXML
    private Button third_card_button;
    @FXML
    private ImageView first_card_imageview;
    @FXML
    private ImageView second_card_imageview;
    @FXML
    private ImageView third_card_imageview;

    /* Card 1 attributes */
    @FXML
    private Label name_card_first;
    @FXML
    private Label type_card_first;
    @FXML
    private Label desc_card_first;

    /* Card 2 attributes */
    @FXML
    private Label name_card_second;
    @FXML
    private Label type_card_second;
    @FXML
    private Label desc_card_second;

    /* Card 3 attributes */
    @FXML
    private Label name_card_third;
    @FXML
    private Label type_card_third;
    @FXML
    private Label desc_card_third;

    private static final int DMG_PER_ROUND = 50;
    private static int round_counter = 0;
    private static String previous_player = "";
    private static String now_player = "";
    private static String next_player = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            /*Show health points*/
            showStatus();

            /* Getting URL path to the images. */
            URL player1A_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamA().getPlayer1().getDomain().getName()+".png");
            URL player2A_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamA().getPlayer2().getDomain().getName()+".png");
            URL player1B_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamB().getPlayer1().getDomain().getName()+".png");
            URL player2B_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamB().getPlayer2().getDomain().getName()+".png");

            /* Setting the images. */
            player1A_imageview.setImage(new Image(String.valueOf(player1A_setImage)));
            player2A_imageview.setImage(new Image(String.valueOf(player2A_setImage)));
            player1B_imageview.setImage(new Image(String.valueOf(player1B_setImage)));
            player2B_imageview.setImage(new Image(String.valueOf(player2B_setImage)));

            /* Who goes first */
            next_player = PassingClass.getInstance().getTeamA().getPlayer1().getName();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_IMAGE);
        }
    }

    public void selectAbility(ActionEvent event){
        try{
            try{
                /* Choosing strategy */
                if(!PassingClass.getInstance().isStrategySet()){
                    if(next_player.equals(PassingClass.getInstance().getTeamA().getPlayer1().getName())){
                        now_player = next_player;
                        enter_label.setText("Let's choose strategy for this game ("+now_player+"):");
                        settingStrategy(event,PassingClass.getInstance().getTeamA().getPlayer1());
                        PassingClass.getInstance().setPlayer1AStrategy(true);
                        next_player = PassingClass.getInstance().getTeamA().getPlayer2().getName();
                    }
                    else if(next_player.equals(PassingClass.getInstance().getTeamA().getPlayer2().getName()){
//TODO
                    }
                }
                if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer1().getName()+"):")){    //player 1A sets his strategy.
                    settingStrategy(event,PassingClass.getInstance().getTeamA().getPlayer1());
                    enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer2().getName()+"):");         //next player's inviting text
                }
                else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer2().getName()+"):")){
                    settingStrategy(event,PassingClass.getInstance().getTeamA().getPlayer2());
                    enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer1().getName()+"):");
                }
                else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer1().getName()+"):")){
                    settingStrategy(event,PassingClass.getInstance().getTeamB().getPlayer1());
                    enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer2().getName()+"):");
                }
                else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer2().getName()+"):")) {
                    settingStrategy(event, PassingClass.getInstance().getTeamB().getPlayer2());
                    try {
                        /* Initializing the deck of cards. */
                        PassingClass.getInstance().getTeamA().getPlayer1().initializeDeck();
                        PassingClass.getInstance().getTeamA().getPlayer2().initializeDeck();
                        PassingClass.getInstance().getTeamB().getPlayer1().initializeDeck();
                        PassingClass.getInstance().getTeamB().getPlayer2().initializeDeck();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(Error.INITIALIZE_DECK);
                    }
                    showStatus();               //actual situation after granting bonuses ending strategy part.

                    next_player = PassingClass.getInstance().getTeamA().getPlayer1().getName();
                    enter_label.setText("Let's move " + next_player + ":");
                    displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(Error.ACTIVATING_STRATEGY);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.GAMEPLAY);
        }

        try{
            if(next_player.equals(PassingClass.getInstance().getTeamA().getPlayer1().getName())){
                now_player = next_player;           //setting who is now
                useAbility(PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamA().getPlayer1(), event); //ability use
                controlDeath();             //check for possible deaths
                showStatus();               //show actual situation

                /* Deciding who will be next */
                if(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().isXpLoaded()){                                   //take xp into account
                    next_player = now_player;
                    enter_label.setText("Let's move "+next_player+":");
                    displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                    PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().unloadXp();                                 //void the bonus
                    dealRoundDmg();                         //damage per round
                }
                else{
                    if(previous_player.equals("") || previous_player.equals(PassingClass.getInstance().getTeamB().getPlayer2().getName())){     //if this is the beginning case
                        if(!PassingClass.getInstance().getTeamB().getPlayer1().isDead()){
                            next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                            displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                        }
                        else{
                            next_player = PassingClass.getInstance().getTeamB().getPlayer2().getName();
                            displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                        }
                    }
                    else if(previous_player.equals(PassingClass.getInstance().getTeamB().getPlayer1().getName())){          //if its the 1B player and there is no 2A.
                        if(!PassingClass.getInstance().getTeamB().getPlayer2().isDead()){                                    //checking if its 1 vs 2 game or 1 vs 1.
                            next_player = PassingClass.getInstance().getTeamB().getPlayer2().getName();
                            displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                        }
                        else{
                            next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                            displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                        }
                    }
                    enter_label.setText("Let's move "+next_player+":");
                    previous_player = now_player;
                }
            }
            else if(next_player.equals(PassingClass.getInstance().getTeamB().getPlayer1().getName())){
                now_player = next_player;           //setting who is now
                useAbility(PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamB().getPlayer1(), event);
                controlDeath();
                showStatus();

                /* Deciding who will be next */
                if(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().isXpLoaded()){
                    next_player = now_player;
                    enter_label.setText("Let's move "+next_player+":");
                    displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                    PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().unloadXp();                                 //void the bonus
                    dealRoundDmg();                         //damage per round
                }
                else{
                    if(previous_player.equals("") || previous_player.equals(PassingClass.getInstance().getTeamA().getPlayer1().getName())){     //if this is the beginning case
                        if(!PassingClass.getInstance().getTeamA().getPlayer2().isDead()){
                            next_player = PassingClass.getInstance().getTeamA().getPlayer2().getName();
                            displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                        }
                        else{
                            next_player = PassingClass.getInstance().getTeamA().getPlayer1().getName();
                            displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                        }
                    }
                    else if(previous_player.equals(PassingClass.getInstance().getTeamA().getPlayer2().getName())){          //if its the 1B player and there is no 2A.
                        if(!PassingClass.getInstance().getTeamB().getPlayer2().isDead()){                                    //checking if its 1 vs 2 game or 1 vs 1.
                            next_player = PassingClass.getInstance().getTeamB().getPlayer2().getName();
                            displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                        }
                        else{
                            next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                            displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                        }
                    }
                    enter_label.setText("Let's move "+next_player+":");
                    previous_player = now_player;
                }
            }
            else if(enter_label.getText().equals("Let's move "+PassingClass.getInstance().getTeamA().getPlayer2().getName()+":")){
                useAbility(PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamA().getPlayer2(), event);
                controlDeath();
                showStatus();
                if(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().isXpLoaded()){
                    enter_label.setText("Let's move "+PassingClass.getInstance().getTeamA().getPlayer2().getName()+":");
                    displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                    PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().unloadXp();
                    dealRoundDmg();
                    System.out.println("Moves Player2A-XPLOAD");
                }
                else{
                    if(!PassingClass.getInstance().getTeamB().getPlayer2().isDead()){
                        enter_label.setText("Let's move "+PassingClass.getInstance().getTeamB().getPlayer2().getName()+":");
                        displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                        System.out.println("Moves Player2B-from Player2A");
                    }
                    else{
                        enter_label.setText("Let's move "+PassingClass.getInstance().getTeamB().getPlayer1().getName()+":");
                        displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                        System.out.println("Moves Player1B-from Player2A");
                    }
                }
            }
            else if(enter_label.getText().equals("Let's move "+PassingClass.getInstance().getTeamB().getPlayer2().getName()+":")){
                useAbility(PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamB().getPlayer2(), event);
                controlDeath();
                showStatus();
                if(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().isXpLoaded()){
                    enter_label.setText("Let's move "+PassingClass.getInstance().getTeamB().getPlayer2().getName()+":");
                    displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                    PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().unloadXp();
                    dealRoundDmg();
                    System.out.println("Moves Player2B-XPLOAD");
                }
                else{
                    if(!PassingClass.getInstance().getTeamA().getPlayer1().isDead()){
                        enter_label.setText("Let's move "+PassingClass.getInstance().getTeamA().getPlayer1().getName()+":");
                        displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                        System.out.println("Moves Player1A-from Player2B");
                    }
                    else{
                        enter_label.setText("Let's move "+PassingClass.getInstance().getTeamA().getPlayer2().getName()+":");
                        displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                        System.out.println("Moves Player2A-from Player2B");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.GAMEPLAY);
        }
    }


    /* ---------------------------- Updating hp and xp  ---------------------------- */
    private void showStatus(){
        /* HP */
        player1A_hp.setText(String.valueOf(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getHp()));
        player2A_hp.setText(String.valueOf(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getHp()));
        player1B_hp.setText(String.valueOf(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getHp()));
        player2B_hp.setText(String.valueOf(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getHp()));

        /* XP */
        player1A_xp.setText(String.valueOf(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getXp()));
        player2A_xp.setText(String.valueOf(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getXp()));
        player1B_xp.setText(String.valueOf(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getXp()));
        player2B_xp.setText(String.valueOf(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getXp()));
    }

    /* ---------------------------- Setting Strategy ---------------------------- */
    private void settingStrategy(ActionEvent event, Player player){
        if(event.getSource() == first_card_button){
            player.getForbidden_card().activate();
        }
        else if(event.getSource() == second_card_button){
            player.getOpen_card().activate();
        }
        else{
            player.getDomain().activate();
        }
    }

    /* ---------------------------- Show Player's options ---------------------------- */
    private void displayCards(Player player){
        try{
            player.getDeck().shuffleDeck();

            /* Show first three cards from the deck */
            showCard(player,0);
            showCard(player,1);
            showCard(player,2);

            /* Load background */
            URL card_setImage = getClass().getResource("arena/card/"+ player.getDomain().getName().toLowerCase() +"_card.png");
            first_card_imageview.setImage(new Image(String.valueOf(card_setImage)));
            second_card_imageview.setImage(new Image(String.valueOf(card_setImage)));
            third_card_imageview.setImage(new Image(String.valueOf(card_setImage)));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_IMAGE);
        }
    }

    private void showCard(Player player, int n){
        try{
            Card card = player.getDeck().drawCard(n);
            switch (n) {
                case 0 -> {
                    name_card_first.setText(card.getName());
                    type_card_first.setText(card.getType());
                    desc_card_first.setText(card.getDescription());
                    name_card_first.setOpacity(1);
                    type_card_first.setOpacity(1);
                    desc_card_first.setOpacity(1);
                }
                case 1 -> {
                    name_card_second.setText(card.getName());
                    type_card_second.setText(card.getType());
                    desc_card_second.setText(card.getDescription());
                    name_card_second.setOpacity(1);
                    type_card_second.setOpacity(1);
                    desc_card_second.setOpacity(1);
                }
                default -> {
                    name_card_third.setText(card.getName());
                    type_card_third.setText(card.getType());
                    desc_card_third.setText(card.getDescription());
                    name_card_third.setOpacity(1);
                    type_card_third.setOpacity(1);
                    desc_card_third.setOpacity(1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_CARDS);
        }
    }
    
    private void controlDeath(){
        try{
            if(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().isDead()){
                PassingClass.getInstance().getTeamA().getPlayer1().kill();
//                System.out.println("Player1A killed.");
                player1A_imageview.setVisible(false);
                player1A_hp_bar.setVisible(false);
                player1A_xp_bar.setVisible(false);
                player1A_deck.setVisible(false);
                player1A_hp.setVisible(false);
                player1A_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().isDead()){
                PassingClass.getInstance().getTeamA().getPlayer2().kill();
//                System.out.println("Player2A killed.");
                player2A_imageview.setVisible(false);
                player2A_hp_bar.setVisible(false);
                player2A_xp_bar.setVisible(false);
                player2A_deck.setVisible(false);
                player2A_hp.setVisible(false);
                player2A_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().isDead()){
                PassingClass.getInstance().getTeamB().getPlayer1().kill();
//                System.out.println("Player1B killed.");
                player1B_imageview.setVisible(false);
                player1B_hp_bar.setVisible(false);
                player1B_xp_bar.setVisible(false);
                player1B_deck.setVisible(false);
                player1B_hp.setVisible(false);
                player1B_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().isDead()){
                PassingClass.getInstance().getTeamB().getPlayer2().kill();
//                System.out.println("Player2B killed.");
                player2B_imageview.setVisible(false);
                player2B_hp_bar.setVisible(false);
                player2B_xp_bar.setVisible(false);
                player2B_deck.setVisible(false);
                player2B_hp.setVisible(false);
                player2B_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamA().getPlayer1().isDead() && PassingClass.getInstance().getTeamA().getPlayer2().isDead()){
                Platform.exit();
            }
            else if(PassingClass.getInstance().getTeamB().getPlayer1().isDead() && PassingClass.getInstance().getTeamB().getPlayer2().isDead()){
                Platform.exit();
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.SETTING_DEATH);
        }
    }

    private void useAbility(Team team_to_attack, Team team_to_support,Player player, ActionEvent event){
        try{
            if(event.getSource() == first_card_button){
                player.useCard(team_to_attack, team_to_support,player.getDeck().drawCard(0), player.getName());
            }
            else if(event.getSource() == second_card_button){
                player.useCard(team_to_attack, team_to_support,player.getDeck().drawCard(1), player.getName());
            }
            else{
                player.useCard(team_to_attack, team_to_support,player.getDeck().drawCard(2), player.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.ABILITY_USE);
        }
    }

    private void dealRoundDmg(){
        if(PassingClass.getInstance().getTeamA().getSumHp() > PassingClass.getInstance().getTeamB().getSumHp()){
            if(!PassingClass.getInstance().getTeamB().getPlayer1().isDead()){
                PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().subtractHp(round_counter*DMG_PER_ROUND);
            }
            if(!PassingClass.getInstance().getTeamB().getPlayer2().isDead()){
                PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().subtractHp(round_counter*DMG_PER_ROUND);
            }
        }
        else if(PassingClass.getInstance().getTeamA().getSumHp() < PassingClass.getInstance().getTeamB().getSumHp()){
            if(!PassingClass.getInstance().getTeamA().getPlayer1().isDead()){
                PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().subtractHp(round_counter*DMG_PER_ROUND);
            }
            if(!PassingClass.getInstance().getTeamA().getPlayer2().isDead()){
                PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().subtractHp(round_counter*DMG_PER_ROUND);
            }
        }
        round_counter++;
    }


}