package com.example.bakubattle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

import java.net.URL;

public class HpProgressBar {

    private AnchorPane MainStage;
    private ImageView hpbar;
    private ImageView hpbar_back;
    private int team;
    public HpProgressBar(AnchorPane pane, int positionX, int positionY, int side)
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
        URL urll1 = this.getClass().getResource("arena/HP_BACK.png");
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
            offsetX = (positionX);
        }
        offsetY = positionY;

        hpbar_back.setX(offsetX);
        hpbar_back.setY(offsetY);

        MainStage.getChildren().add(hpbar_back);

        hpbar = new ImageView();
        URL urll = this.getClass().getResource("arena/HP_FRONT.png");
        Image im = new Image(String.valueOf(urll));
        hpbar.setImage(im);
        hpbar.setX(offsetX + 4);
        hpbar.setY(offsetY + 4);

        MainStage.getChildren().add(hpbar);

        hpbar.setFitWidth(249);
        hpbar.setFitHeight(44);
        hpbar_back.setFitWidth(258);
        hpbar_back.setFitHeight(53);
        if(side == 1)
        {
            hpbar.getTransforms().add(new Rotate(180,offsetX,offsetY + hpbar.getFitHeight()/2 + 4)); //rotacja
            hpbar_back.getTransforms().add(new Rotate(180,offsetX,offsetY + hpbar_back.getFitHeight()/2 )); //rotacja wartosci (default 30) muszą byc rowne sobie, zwiekszenie obnizy pasek, zmiejszenie podwyzszy
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

    public void hide(){
        hpbar.setVisible(false);
        hpbar_back.setVisible(false);
    }
}
