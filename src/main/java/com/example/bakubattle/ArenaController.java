package com.example.bakubattle;

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
    private ProgressBar player1A_xp_bar;
    @FXML
    private ImageView player1A_deck;

    /* Player 2A attributes */
    @FXML
    private ImageView player2A_imageview;
    @FXML
    private  ProgressBar player2A_hp_bar;
    @FXML
    private ProgressBar player2A_xp_bar;
    @FXML
    private ImageView player2A_deck;

    /* Player 1B attributes */
    @FXML
    private ImageView player1B_imageview;
    @FXML
    private  ProgressBar player1B_hp_bar;
    @FXML
    private ProgressBar player1B_xp_bar;
    @FXML
    private ImageView player1B_deck;

    /* Player 2A attributes */
    @FXML
    private ImageView player2B_imageview;
    @FXML
    private  ProgressBar player2B_hp_bar;
    @FXML
    private ProgressBar player2B_xp_bar;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
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

            enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer1().getName()+"):");         //inviting text
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_IMAGE);
        }
    }

    public void selectAbility(ActionEvent event){
        try{
            /* By checking the label text we determine which type of event we are handling */
            if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer1().getName()+"):")){
                settingStrategy(event,PassingClass.getInstance().getTeamA().getPlayer1());
                enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer2().getName()+"):");
            }
            else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer2().getName()+"):")){
                settingStrategy(event,PassingClass.getInstance().getTeamA().getPlayer2());
                enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer1().getName()+"):");
            }
            else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer1().getName()+"):")){
                settingStrategy(event,PassingClass.getInstance().getTeamB().getPlayer1());
                enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer2().getName()+"):");
            }
            else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer2().getName()+"):")){
                settingStrategy(event,PassingClass.getInstance().getTeamB().getPlayer2());
                enter_label.setText("Let's move "+PassingClass.getInstance().getTeamA().getPlayer1().getName()+":");            //inviting text
                try{
                    /* Initializing the deck of cards. */
                    PassingClass.getInstance().getTeamA().getPlayer1().initializeDeck();
                    PassingClass.getInstance().getTeamA().getPlayer2().initializeDeck();
                    PassingClass.getInstance().getTeamB().getPlayer1().initializeDeck();
                    PassingClass.getInstance().getTeamB().getPlayer2().initializeDeck();
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println(Error.INITIALIZE_DECK);
                }
                displayCards(PassingClass.getInstance().getTeamA().getPlayer1());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.ACTIVATING_STRATEGY);
        }
    }

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

    private void displayCards(Player player){
        try{
            for(int i = 0; i<4;i++){
                player.getDeck().shuffleDeck();
            }

            showCard(player,0);
            showCard(player,1);
            showCard(player,2);

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
}