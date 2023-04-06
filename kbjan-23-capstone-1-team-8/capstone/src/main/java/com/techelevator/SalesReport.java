package com.techelevator;

public class SalesReport {

    VendingMachine vendingMachine = new VendingMachine();

    public SalesReport(){

    }

    public void generateSalesReport(){
        double profit = 0;
        for (Product product : vendingMachine.getProductList()){
            int quantity = product.getQuantity();
            int quantitySold = 5 - quantity;
            profit += quantitySold * product.getPrice();
            System.out.println(product.getName() + "|" + quantitySold);
        }
        System.out.println();
        System.out.println("**TOTAL SALES** $" + profit);
    }









}
