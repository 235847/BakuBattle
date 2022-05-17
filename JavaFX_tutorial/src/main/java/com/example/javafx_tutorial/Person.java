package com.example.javafx_tutorial;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

//    this -> object of class Person, firstName -> name of the StringProperty, "" -> default value
    private StringProperty firstName = new SimpleStringProperty(this,"firstName","");

    public String getFirstName() {
        return firstName.get();
    }

    /**
     * @description Method that interpreters firstName not as String but as StringProperty.
     * @return StringProperty.
     */
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
