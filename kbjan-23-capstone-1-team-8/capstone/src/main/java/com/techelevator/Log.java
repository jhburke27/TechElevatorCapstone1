package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

public class Log {
    public Log(){

    }
    String outputFile = "C:\\Users\\Student\\workspace\\kbjan-23-capstone-1-team-8\\capstone\\Log.txt";
    File output = new File(outputFile);

    public void printLog(String transactionType, double transactionAmount, double balance){
        Calendar cals = Calendar.getInstance();
        try(PrintWriter dataOutput = new PrintWriter(new FileOutputStream(output, true))){
            dataOutput.println(cals.getTime() + " " + transactionType + ": " + "$" + transactionAmount + " $" + balance);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

}
