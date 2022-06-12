package com.example.bakubattle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.net.URL;

public class XpProgressBar {

    private AnchorPane MainStage;
    private ImageView hpbar;
    private ImageView hpbar_back;
    private int team;
    public XpProgressBar(AnchorPane pane, int positionX, int positionY, int side)
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
        hpbar_back = new ImageView();
        URL urll1 = this.getClass().getResource("arena/XP_BACK.png");
        Image im1 = new Image(String.valueOf(urll1));
        hpbar_back.setImage(im1);
        int offsetX;
        int offsetY;
        if(side == 1)
        {
            offsetX = (1920 - positionX);
        }
        else
        {
            offsetX = (positionX+100);
        }
        offsetY = positionY+50;

        hpbar_back.setX(offsetX);
        hpbar_back.setY(offsetY);

        MainStage.getChildren().add(hpbar_back);

        hpbar = new ImageView();
        URL urll = this.getClass().getResource("arena/XP_FRONT.png");
        Image im = new Image(String.valueOf(urll));
        hpbar.setImage(im);
        hpbar.setX(offsetX + 4);
        hpbar.setY(offsetY);

        hpbar.setFitHeight(28);
        hpbar.setFitWidth(192);

        hpbar_back.setFitHeight(30);
        hpbar_back.setFitWidth(197);

        MainStage.getChildren().add(hpbar);
        if(side == 1)
        {
            hpbar.getTransforms().add(new Translate((hpbar.getFitWidth()/2 +4)* -1,0,0));
            hpbar.getTransforms().add(new Rotate(180,offsetX,offsetY + hpbar.getFitHeight()/2));
            hpbar_back.getTransforms().add(new Translate(hpbar_back.getFitWidth()*1.5 * -1 -4,0,0));
        }
        hpbar.toBack();
        hpbar_back.toBack();
    }

    private double calculate_width(Number max, Number current)
    {
        if(current.doubleValue() == 0)
        {
            return 0.1;
        }
        else if(current.doubleValue() > max.doubleValue())
        {
            return 192;
        }
        else
        {
            return 192 * (current.doubleValue()/max.doubleValue());
        }
    }

    public void setValue(Number bakuganMaxHp, Number bakuganCurrentHp)
    {
        hpbar.setFitWidth(calculate_width(bakuganMaxHp, bakuganCurrentHp));
    }


    public void hide(){
        hpbar.setVisible(false);
        hpbar_back.setVisible(false);
    }
}
