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
        ImageView imageView1 = new ImageView();
        URL urll1 = this.getClass().getResource("arena/XP_BACK.png");
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
            offsetX = (positionX+100);
        }
        offsetY = positionY+50;

        imageView1.setX(offsetX);
        imageView1.setY(offsetY);

        MainStage.getChildren().add(imageView1);

        hpbar = new ImageView();
        URL urll = this.getClass().getResource("arena/XP_FRONT.png");
        Image im = new Image(String.valueOf(urll));
        hpbar.setImage(im);
        hpbar.setX(offsetX + 4);
        hpbar.setY(offsetY);

        hpbar.setFitHeight(28);
        hpbar.setFitWidth(192);

        imageView1.setFitHeight(30);
        imageView1.setFitWidth(197);

        MainStage.getChildren().add(hpbar);
        if(side == 1)
        {
            hpbar.getTransforms().add(new Translate((hpbar.getFitWidth()/2 +4)* -1,0,0));
            hpbar.getTransforms().add(new Rotate(180,offsetX,offsetY + hpbar.getFitHeight()/2));
            imageView1.getTransforms().add(new Translate(imageView1.getFitWidth()*1.5 * -1 -4,0,0));
        }
        hpbar.toBack();
        imageView1.toBack();
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

}
