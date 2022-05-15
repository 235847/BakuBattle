package com.example.javafx_tutorial;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(){
        name = "";
        price = 0;
        quantity = 0;
    }

    public Product(String n,double p, int q){
        name = n;
        price = p;
        quantity = q;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
