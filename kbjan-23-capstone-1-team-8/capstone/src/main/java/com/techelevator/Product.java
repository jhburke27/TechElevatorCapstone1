package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Product extends VendingMachineCLI{

    private String slot;

    private String name;

    private double price;

    private String type;

    private int quantity;





    public Product(String slot, String name, double price, String type){
        super();
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        quantity = 5;
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

    public String getSlot() {
        return slot;
    }

    public String getType() {
        return type;
    }

public void dispense(){
        quantity -= 1;
}


}
