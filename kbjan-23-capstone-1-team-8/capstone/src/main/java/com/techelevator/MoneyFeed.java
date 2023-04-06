package com.techelevator;

import java.util.Scanner;

public class MoneyFeed {
    private double currentBalance;
    Log log = new Log();


    Scanner input = new Scanner(System.in);

    public MoneyFeed() {
        this.currentBalance = 0;
    }

    public void addMoney() {
        System.out.println("Enter a whole dollar amount to add to the current balance");
        String dollarAmount = input.nextLine();
        int amount = Integer.parseInt(dollarAmount);
        if(amount % 2 == 0 || amount % 2 == 1) {
            if(amount > 0) {
                currentBalance += amount;
                log.printLog("Feed Money", amount, currentBalance);
            } else{
                System.out.println("Invalid amount entered. Please enter a whole dollar amount.");
            }
        } else{
            System.out.println("Invalid amount entered. Please enter a whole dollar amount.");
        }

    }

    public void dispenseChange() {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        double change = currentBalance;
        int changeInCents = (int) (currentBalance * 100);
        while (changeInCents > 0) {
            if (changeInCents >= 25) {
                changeInCents -= 25;
                quarters++;
            } else if (changeInCents >= 10) {
                changeInCents -= 10;
                dimes++;

            } else if (changeInCents >= 5) {
                changeInCents -= 5;
                nickels++;
            } else {
                changeInCents -= 1;
                pennies++;
            }

        } System.out.println("Amount of change to be received : $" + currentBalance);
        currentBalance = 0;
        log.printLog("Give Change", change, currentBalance);
        System.out.println(quarters + " Quarters " + dimes + " Dimes " + nickels + " Nickels " + pennies + " Pennies " );
    }





    public double getCurrentBalance() {
        return currentBalance;
    }

    public void payment(double cost){
        currentBalance -= cost;
    }


}
