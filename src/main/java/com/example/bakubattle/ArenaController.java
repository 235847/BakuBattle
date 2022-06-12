package com.example.bakubattle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    @FXML
    private AnchorPane MainStage;

    /* Player 1A attributes */
    @FXML
    private Label player1A;
    @FXML
    private ImageView player1A_imageview;
    @FXML
    private ImageView player1A_hp_bar_back;
    @FXML
    private ImageView player1A_hp_bar_front;
    @FXML
    private Label player1A_hp;
    @FXML
    private ImageView player1A_xp_bar_back;
    @FXML
    private ImageView player1A_xp_bar_front;
    @FXML
    private  Label player1A_xp;

    /* Player 2A attributes */
    @FXML
    private Label player2A;
    @FXML
    private ImageView player2A_imageview;
    @FXML
    private ImageView player2A_hp_bar_back;
    @FXML
    private ImageView player2A_hp_bar_front;
    @FXML
    private  Label player2A_hp;
    @FXML
    private ImageView player2A_xp_bar_back;
    @FXML
    private ImageView player2A_xp_bar_front;
    @FXML
    private  Label player2A_xp;


    /* Player 1B attributes */
    @FXML
    private Label player1B;
    @FXML
    private ImageView player1B_imageview;
    @FXML
    private ImageView player1B_hp_bar_back;
    @FXML
    private ImageView player1B_hp_bar_front;
    @FXML
    private  Label player1B_hp;
    @FXML
    private ImageView player1B_xp_bar_back;
    @FXML
    private ImageView player1B_xp_bar_front;
    @FXML
    private  Label player1B_xp;


    /* Player 2B attributes */
    @FXML
    private Label player2B;
    @FXML
    private ImageView player2B_imageview;
    @FXML
    private ImageView player2B_hp_bar_back;
    @FXML
    private ImageView player2B_hp_bar_front;
    @FXML
    private  Label player2B_hp;
    @FXML
    private ImageView player2B_xp_bar_back;
    @FXML
    private ImageView player2B_xp_bar_front;
    @FXML
    private  Label player2B_xp;

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

    /*Surrender buttons*/
    @FXML
    private Button teamAsurrender;
    @FXML
    private Button teamBsurrender;

    private static final int DMG_PER_ROUND = 50;
    private static int round_counter = 0;
    private static String previous_player = "";
    private static String now_player = "";
    private static String next_player = "";

    private HpProgressBar bar_1A_hp;
    private HpProgressBar bar_1B_hp;
    private HpProgressBar bar_2A_hp;
    private HpProgressBar bar_2B_hp;
    private XpProgressBar bar_1A_xp;
    private XpProgressBar bar_1B_xp;
    private XpProgressBar bar_2A_xp;
    private XpProgressBar bar_2B_xp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            /* Show names */
            player1A.setText(PassingClass.getInstance().getTeamA().getPlayer1().getName());
            player2A.setText(PassingClass.getInstance().getTeamA().getPlayer2().getName());
            player1B.setText(PassingClass.getInstance().getTeamB().getPlayer1().getName());
            player2B.setText(PassingClass.getInstance().getTeamB().getPlayer2().getName());

            bar_1A_hp = new HpProgressBar(MainStage,300,100,-1);
            bar_1B_hp = new HpProgressBar(MainStage,300,100,1);
            bar_2A_hp = new HpProgressBar(MainStage,300,730,-1);
            bar_2B_hp = new HpProgressBar(MainStage,300,730,1);

            bar_1A_xp = new XpProgressBar(MainStage,200,100,-1);
            bar_1B_xp = new XpProgressBar(MainStage,200,100,1);
            bar_2A_xp = new XpProgressBar(MainStage,200,730,-1);
            bar_2B_xp = new XpProgressBar(MainStage,200,730,1);

            /* Show health points */
            showStatus();


            MainStage.toBack();
            /* Getting URL path to the images. */
//            System.out.println("arena/bakugan/"+PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamA().getPlayer1().getDomain().getName()+".png");
//            System.out.println("arena/bakugan/"+PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamA().getPlayer2().getDomain().getName()+".png");
//            System.out.println("arena/bakugan/"+PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamB().getPlayer1().getDomain().getName()+".png");
//            System.out.println("arena/bakugan/"+PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamB().getPlayer2().getDomain().getName()+".png");
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
            enter_label.setText("Let's choose strategy for this game ("+next_player+"):");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_IMAGE);
        }
    }

    public void selectAbility(ActionEvent event){
        try{
            /* Choosing strategy */
            if(!PassingClass.getInstance().isStrategySet()){
                if(next_player.equals(PassingClass.getInstance().getTeamA().getPlayer1().getName())){
                    now_player = next_player;
                    settingStrategy(event,PassingClass.getInstance().getTeamA().getPlayer1());
                    PassingClass.getInstance().setPlayer1AStrategy(true);
                    next_player = PassingClass.getInstance().getTeamA().getPlayer2().getName();
                    enter_label.setText("Let's choose strategy for this game ("+next_player+"):");
                }
                else if(next_player.equals(PassingClass.getInstance().getTeamA().getPlayer2().getName())){
                    now_player = next_player;
                    settingStrategy(event,PassingClass.getInstance().getTeamA().getPlayer2());
                    PassingClass.getInstance().setPlayer2AStrategy(true);
                    next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                    enter_label.setText("Let's choose strategy for this game ("+next_player+"):");
                }
                else if(next_player.equals(PassingClass.getInstance().getTeamB().getPlayer1().getName())) {
                    now_player = next_player;
                    settingStrategy(event, PassingClass.getInstance().getTeamB().getPlayer1());
                    PassingClass.getInstance().setPlayer1BStrategy(true);
                    next_player = PassingClass.getInstance().getTeamB().getPlayer2().getName();
                    enter_label.setText("Let's choose strategy for this game ("+next_player+"):");
                }
                else if(next_player.equals(PassingClass.getInstance().getTeamB().getPlayer2().getName())){
                    now_player = next_player;
                    settingStrategy(event, PassingClass.getInstance().getTeamB().getPlayer2());
                    PassingClass.getInstance().setPlayer2BStrategy(true);
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
                    enter_label.setText("Let's move " + next_player + ":");      //inviting text
                    displayCards(PassingClass.getInstance().getTeamA().getPlayer1());   //show player's cards
                }
            }
            else if(PassingClass.getInstance().isStrategySet()){        /* Proper Gameplay */
                if(next_player.equals(PassingClass.getInstance().getTeamA().getPlayer1().getName())){           //if player 1A goes
                    now_player = next_player;           //setting who is now
                    useAbility(PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamA().getPlayer1(), event); //ability use
                    controlDeath();             //check for possible deaths
                    showStatus();               //show actual situation

                    /* Deciding who goes next */
                    if(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().isXpLoaded()){                                   //take xp into account
                        next_player = now_player;
                        enter_label.setText("Let's move "+next_player+":");
                        displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                        PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().unloadXp();                                 //void the bonus
                        dealRoundDmg();                         //damage per round
                    }
                    else{
                        if(previous_player.equals("")){             //default branch
                            next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                            displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                        }
                        else if(previous_player.equals(PassingClass.getInstance().getTeamB().getPlayer1().getName())){      // 2B died and maybe 2A
                            if(!PassingClass.getInstance().getTeamB().getPlayer2().isDead()){
                                next_player = PassingClass.getInstance().getTeamB().getPlayer2().getName();
                                displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                            }
                            else{
                                next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                                displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                            }
                        }
                        else if(previous_player.equals(PassingClass.getInstance().getTeamB().getPlayer2().getName())){  // No idea who died maybe 1B but not sure.
                            if(!PassingClass.getInstance().getTeamB().getPlayer1().isDead()){           // classic 2 vs 2 tour
                                next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                                displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                            }
                            else{       //1B is dead, switch to 2B
                                next_player = PassingClass.getInstance().getTeamB().getPlayer2().getName();
                                displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                            }
                        }
                        enter_label.setText("Let's move "+next_player+":");
                        previous_player = now_player;
                    }
                }
                else if(next_player.equals(PassingClass.getInstance().getTeamB().getPlayer1().getName())){          //if player 1B goes
                    now_player = next_player;           //setting who is now
                    useAbility(PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamB().getPlayer1(), event); //ability use
                    controlDeath();             //check for possible deaths
                    showStatus();               //show actual situation

                    /* Deciding who goes next */
                    if(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().isXpLoaded()){                       //take xp into account
                        next_player = now_player;
                        enter_label.setText("Let's move "+next_player+":");
                        displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                        PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().unloadXp();                                 //void the bonus
                        dealRoundDmg();                         //damage per round
                    }
                    else{
                        if(previous_player.equals(PassingClass.getInstance().getTeamA().getPlayer2().getName())){      // 1A died and maybe 2B
                            if(!PassingClass.getInstance().getTeamA().getPlayer1().isDead()) {
                                next_player = PassingClass.getInstance().getTeamA().getPlayer1().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                            }
                            else{
                                next_player = PassingClass.getInstance().getTeamA().getPlayer2().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                            }
                        }
                        else if(previous_player.equals(PassingClass.getInstance().getTeamA().getPlayer1().getName())){      //no idea who died
                            if(!PassingClass.getInstance().getTeamA().getPlayer2().isDead()){
                                next_player = PassingClass.getInstance().getTeamA().getPlayer2().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                            }
                            else{
                                next_player = PassingClass.getInstance().getTeamA().getPlayer1().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                            }
                        }
                        enter_label.setText("Let's move "+next_player+":");
                        previous_player = now_player;
                    }
                }
                else if(next_player.equals(PassingClass.getInstance().getTeamA().getPlayer2().getName())) {          //if player 2A goes
                    now_player = next_player;           //setting who is now
                    useAbility(PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamA().getPlayer2(), event);
                    controlDeath();
                    showStatus();

                    /* Deciding who goes next */
                    if(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().isXpLoaded()){
                        next_player = now_player;
                        enter_label.setText("Let's move "+next_player+":");
                        displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                        PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().unloadXp();                                 //void the bonus
                        dealRoundDmg();                         //damage per round
                    }
                    else{
                        if(previous_player.equals(PassingClass.getInstance().getTeamB().getPlayer2().getName())){      // 1B died
                            if(!PassingClass.getInstance().getTeamB().getPlayer1().isDead()){
                                next_player = PassingClass.getInstance().getTeamB().getPlayer1().getName();
                                displayCards(PassingClass.getInstance().getTeamB().getPlayer1());
                            }
                            else{
                                next_player = PassingClass.getInstance().getTeamB().getPlayer2().getName();
                                displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                            }
                        }
                        else if(previous_player.equals(PassingClass.getInstance().getTeamB().getPlayer1().getName())){      //no idea who died
                            if(!PassingClass.getInstance().getTeamB().getPlayer2().isDead()){
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
                else if(next_player.equals(PassingClass.getInstance().getTeamB().getPlayer2().getName())) {          //if player 2B goes
                    now_player = next_player;           //setting who is now
                    useAbility(PassingClass.getInstance().getTeamA(),PassingClass.getInstance().getTeamB(),PassingClass.getInstance().getTeamB().getPlayer2(), event); //ability use
                    controlDeath();             //check for possible deaths
                    showStatus();               //show actual situation

                    /* Deciding who goes next */
                    if(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().isXpLoaded()){                       //take xp into account
                        next_player = now_player;
                        enter_label.setText("Let's move "+next_player+":");
                        displayCards(PassingClass.getInstance().getTeamB().getPlayer2());
                        PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().unloadXp();                                 //void the bonus
                        dealRoundDmg();                         //damage per round
                    }
                    else {
                        if(previous_player.equals(PassingClass.getInstance().getTeamA().getPlayer1().getName())){      // 2A died
                            if(!PassingClass.getInstance().getTeamA().getPlayer2().isDead()){
                                next_player = PassingClass.getInstance().getTeamA().getPlayer2().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                            }
                            else{
                                next_player = PassingClass.getInstance().getTeamA().getPlayer1().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                            }
                        }
                        else if(previous_player.equals(PassingClass.getInstance().getTeamA().getPlayer2().getName())){      //no idea who died
                            if(!PassingClass.getInstance().getTeamA().getPlayer1().isDead()){
                                next_player = PassingClass.getInstance().getTeamA().getPlayer1().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
                            }
                            else{
                                next_player = PassingClass.getInstance().getTeamA().getPlayer2().getName();
                                displayCards(PassingClass.getInstance().getTeamA().getPlayer2());
                            }
                        }
                        enter_label.setText("Let's move "+next_player+":");
                        previous_player = now_player;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.GAMEPLAY + "\n" + Error.ACTIVATING_STRATEGY);
        }
    }

    /* ---------------------------- Updating hp and xp  ---------------------------- */
    private void showStatus(){
        /*Checking for overhealth*/
        if(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getHp() >= Bakugan.HP_THRESHOLD){
            PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().doubleHp_negative();
        }
        if(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getHp() >= Bakugan.HP_THRESHOLD){
            PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().doubleHp_negative();
        }
        if(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getHp() >= Bakugan.HP_THRESHOLD){
            PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().doubleHp_negative();
        }
        if(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getHp() >= Bakugan.HP_THRESHOLD){
            PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().doubleHp_negative();
        }

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

        //update hp and xp bar
        bar_1A_hp.setValue(Bakugan.HP_THRESHOLD,PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getHp());
        bar_2A_hp.setValue(Bakugan.HP_THRESHOLD,PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getHp());
        bar_1B_hp.setValue(Bakugan.HP_THRESHOLD,PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getHp());
        bar_2B_hp.setValue(Bakugan.HP_THRESHOLD,PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getHp());

        bar_1A_xp.setValue(1,PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getXp());
        bar_2A_xp.setValue(1,PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getXp());
        bar_1B_xp.setValue(1,PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getXp());
        bar_2B_xp.setValue(1,PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getXp());

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

    /* ---------------------------- Displaying card's data ---------------------------- */
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

    /* ---------------------------- Killing players  ---------------------------- */
    private void controlDeath(){
        try{
            if(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().isDead()){
                PassingClass.getInstance().getTeamA().getPlayer1().kill();
//                System.out.println("Player1A killed.");
                player1A.setVisible(false);
                bar_1A_hp.hide();
                bar_1A_xp.hide();
                player1A_imageview.setVisible(false);
                player1A_hp.setVisible(false);
                player1A_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().isDead()){
                PassingClass.getInstance().getTeamA().getPlayer2().kill();
//                System.out.println("Player2A killed.");
                player2A.setVisible(false);
                bar_2A_hp.hide();
                bar_2A_xp.hide();
                player2A_imageview.setVisible(false);
                player2A_hp.setVisible(false);
                player2A_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().isDead()){
                PassingClass.getInstance().getTeamB().getPlayer1().kill();
//                System.out.println("Player1B killed.");
                player1B.setVisible(false);
                bar_1B_hp.hide();
                bar_1B_xp.hide();
                player1B_imageview.setVisible(false);
                player1B_hp.setVisible(false);
                player1B_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().isDead()){
                PassingClass.getInstance().getTeamB().getPlayer2().kill();
//                System.out.println("Player2B killed.");
                player2B.setVisible(false);
                bar_2B_hp.hide();
                bar_2B_xp.hide();
                player2B_imageview.setVisible(false);
                player2B_hp.setVisible(false);
                player2B_xp.setVisible(false);
            }
            if(PassingClass.getInstance().getTeamA().getPlayer1().isDead() && PassingClass.getInstance().getTeamA().getPlayer2().isDead()){
                endgame();
            }
            else if(PassingClass.getInstance().getTeamB().getPlayer1().isDead() && PassingClass.getInstance().getTeamB().getPlayer2().isDead()){
                endgame();
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.SETTING_DEATH);
        }
    }

    /* ---------------------------- Activating cards  ---------------------------- */
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

    /* ---------------------------- Damage that is dealt per "round" in our meaning  ---------------------------- */
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

    public void surrender(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Surrender");
        alert.setHeaderText("You are about to give up");
        alert.setContentText("Are you sure you want to surrender and quit ?");
        if(alert.showAndWait().get()== ButtonType.OK){
            Stage stage = (Stage) teamAsurrender.getScene().getWindow();
            stage.close();
        }
    }

    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button close = new Button("Close the window");
        close.setOnAction(actionEvent -> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,close);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,200,150);
        window.setScene(scene);
        window.showAndWait();
        Platform.exit();
    }
    private void endgame(){
        if(PassingClass.getInstance().getTeamA().getPlayer1().isDead() && PassingClass.getInstance().getTeamA().getPlayer2().isDead()){
            display("TEAM B WON","NICE, TEAM B WON");
        }
        else{
            display("TEAM A WON","NICE, TEAM A WON");
        }
    }
}