package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    MoneyFeed moneyFeed = new MoneyFeed();

    public MoneyFeed getMoneyFeed() {
        return moneyFeed;
    }

    Log log = new Log();

    public void displayItems() {

        for (Product product : productList) {
        String slot = product.getSlot();
        String name = product.getName();
        double price = product.getPrice();
        int quantity = product.getQuantity();
        System.out.print(slot);
        System.out.print(", " + name);
        System.out.print(", " + "$" + price);
        if(quantity == 0){
            System.out.println(", SOLD OUT");
        } else {
            System.out.println(", Quantity: " + quantity);
        }


    }
}





    private ArrayList<Product> productList = new ArrayList<>();
    public void ProductsFromFile(){

        File inventoryFile = new File("C:\\Users\\Student\\workspace\\kbjan-23-capstone-1-team-8\\capstone\\vendingmachine.csv");
        try(Scanner fileScanner = new Scanner(inventoryFile)){
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] products = line.split("\\|");
                String slot = products[0];
                String name = products[1];
                String price = products[2];
                double priceDouble = Double.parseDouble(price);
                String type = products[3];
                Product product = new Product(slot, name, priceDouble, type);
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file.");
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void purchase(){
        int counter = 0;
        displayItems();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter code for desired item.");
        String userInput = input.nextLine();
        for(Product product : productList){
            if(userInput.equals(product.getSlot())){
                if(product.getQuantity() == 0){
                    System.out.println("Item is currently sold out.");
                } else if (moneyFeed.getCurrentBalance() - product.getPrice() >= 0){

                    moneyFeed.payment(product.getPrice());
                    String transactionType = product.getName() + " " + product.getSlot();
                    log.printLog(transactionType, product.getPrice(), moneyFeed.getCurrentBalance());
                    product.dispense();
                    System.out.println(product.getName() + ", " + product.getPrice() + ", Balance remaining: " + moneyFeed.getCurrentBalance());
                    if (product.getType().equals("Chip")) {
                        System.out.println("Crunch Crunch, Yum!");
                    } else if (product.getType().equals("Candy")) {
                        System.out.println("Munch Munch, Yum!");
                    } else if (product.getType().equals("Drink")) {
                        System.out.println("Glug Glug, Yum!");
                    } else {
                        System.out.println("Chew Chew, Yum!");

                    }

                }else{
                    System.out.println("Insufficient Funds for selected item.");
                }
            }else {
                counter++;
                if (counter == 16){
                    System.out.println("Please enter a valid code.");
                }
            }
        }


    }
}
