package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

import java.net.URL;

public class HpProgress {
    private AnchorPane MainStage;
    private ImageView hpbar;
    private int team;
    public HpProgress(AnchorPane pane, int positionX, int positionY, int side)
    {
        // ----- README -----
        //side moze miec wartosc 0 albo 1 (drużyna A i drużyna B)
        //positionX to offset od krawedzi bocznej ekranu
        //positionY to offset od krawędzi górnej ekranu
        //przy side -1 offset liczony jest od lewego boku paska hp
        //przy side 1 offset liczony jest od prawego boku paska hp
        //offset od gory liczony jest od gornej krawedzi paska hp
        //gdyby paski nie byly na rowno wysokosciowo trzeba pobawic sie
        //wartoscia dodawana przy rotacji (ctrl + f: rotacja)
        team = side;
        MainStage = pane;
        ImageView imageView1 = new ImageView();
        URL urll1 = this.getClass().getResource("HP_BACK.png");
        Image im1 = new Image(String.valueOf(urll1));
        imageView1.setImage(im1);
        int offsetX;
        int offsetY;
        if(side == 1)
        {
            offsetX = (1920 - positionX);
        }
        else
        {
            offsetX = (positionX);
        }
        offsetY = positionY;

        imageView1.setX(offsetX);
        imageView1.setY(offsetY);

        MainStage.getChildren().add(imageView1);

        hpbar = new ImageView();
        URL urll = this.getClass().getResource("HP_FRONT.png");
        Image im = new Image(String.valueOf(urll));
        hpbar.setImage(im);
        hpbar.setX(offsetX + 4);
        hpbar.setY(offsetY + 4);

        MainStage.getChildren().add(hpbar);

        hpbar.setFitWidth(249);
        if(side == 1)
        {
            hpbar.getTransforms().add(new Rotate(180,offsetX,offsetY + 30)); //rotacja
            imageView1.getTransforms().add(new Rotate(180,offsetX,offsetY + 30)); //rotacja wartosci (default 30) muszą byc rowne sobie, zwiekszenie obnizy pasek, zmiejszenie podwyzszy
        }
        hpbar.getLayoutX();
        hpbar.getLayoutY();
    }

    private double calculate_width(Number max, Number current)
    {
        if(current.doubleValue() == 0)
        {
            return 0.1;
        }
        else if(current.doubleValue() > max.doubleValue())
        {
            return 249;
        }
        else
        {
            return 249 * (current.doubleValue()/max.doubleValue());
        }
    }

    public void setValue(Number bakuganMaxHp, Number bakuganCurrentHp)
    {
        hpbar.setFitWidth(calculate_width(bakuganMaxHp, bakuganCurrentHp));
    }
}
