package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private AnchorPane MainStage;

    @FXML
    private Slider slider;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HpProgress bar = new HpProgress(MainStage,200,200,-1);
        HpProgress bar2 = new HpProgress(MainStage,200,200,1);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<?extends Number> observable, Number oldValue, Number newValue){
                bar.setValue(100, newValue);
                bar2.setValue(100,newValue);
            }
        });
    }
}
