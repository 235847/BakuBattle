package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;

public class HpProgress {
    private AnchorPane MainStage;
    private ImageView hpbar;
    public HpProgress(AnchorPane pane,int positionX,int positionY)
    {
        MainStage = pane;
        ImageView imageView1 = new ImageView();
        URL urll1 = this.getClass().getResource("HP_BACK.png");
        Image im1 = new Image(String.valueOf(urll1));
        imageView1.setImage(im1);
        imageView1.setX(positionX);
        imageView1.setY(positionY);
        MainStage.getChildren().add(imageView1);

        hpbar = new ImageView();
        URL urll = this.getClass().getResource("HP_FRONT.png");
        Image im = new Image(String.valueOf(urll));
        hpbar.setImage(im);
        hpbar.setX(positionX + 4);
        hpbar.setY(positionY + 4);

        MainStage.getChildren().add(hpbar);

        hpbar.setFitWidth(249);
        hpbar.setPreserveRatio(false);
        hpbar.setPickOnBounds(true);
    }

    private double calculate_width(Number max, Number current)
    {
        if(current.intValue() == 0)
        {
            return 0.1;
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
