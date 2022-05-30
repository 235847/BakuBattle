package com.example.bakubattle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    @FXML
    private Label manaPlayer1;
    @FXML
    private Label hpPlayer1;
    @FXML
    private Label hpPlayer2;
    @FXML
    private Label manaPlayer2;
    @FXML
    private ImageView baku1;
    @FXML
    private AnchorPane bakuAndBut;

    @FXML
    private Button invisibleBut;
    @FXML
    private VBox vbox1;

    DraggableMaker draggableMaker = new DraggableMaker();


    private Player player1;
    private Player player2;
    private Deck deck;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //invisibleBut.setVisible(false);

        draggableMaker.makeDraggable(bakuAndBut);

        deck = new Deck();
        deck.shuffleDeck();
        player1 = new Player(deck.drawCard());
        player2 = new Player(deck.drawCard());

        manaPlayer1.setText(Integer.toString(player1.getCurrent_mana()));
        hpPlayer1.setText(Integer.toString(player1.getHp()));
        manaPlayer2.setText(Integer.toString(player2.getCurrent_mana()));
        hpPlayer2.setText(Integer.toString(player2.getHp()));

//        invisibleBut.setVisible(false);
//        invisibleBut.setLayoutX(baku1.getLayoutX() + 247);
//        invisibleBut.setLayoutY(baku1.getLayoutY() + 269);
//        invisibleBut.layoutYProperty().bindBidirectional(baku1.layoutYProperty());
//        invisibleBut.layoutXProperty().bindBidirectional(baku1.layoutXProperty());
//        invisibleBut.layoutXProperty().bind(baku1.layoutXProperty().add(247));
    }
    @FXML
    private void attackHero(){
        //player2.setHp(player2.getHp()- player2.getPlayer_deck().get(0).getAttack());
        player2.setHp(player2.getHp()- 6);
        hpPlayer2.setText(Integer.toString(player2.getHp()));
    }
}