/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;
import static minesweeper.BestTimesPrint.printBeginnerBestTimes;

/**
 *
 * @author Keith Banner, Nikki Huntsman
 */


public class BestTimesCalculator {        
    public static void main(String args[])   
        throws java.io.IOException{
        BestTimesCalculator BestTimesCalculator = new BestTimesCalculator();
        BestTimesCalculator.checkBestTimeEligibility();
    }
    public double newTime;
    
    Name Name = new Name();
    public String playerName;
    
    public void checkBestTimeEligibility()    
        throws java.io.IOException{
        playerName = Name.getName();
        System.out.println(playerName);
        Scanner input = new Scanner(System.in);
        BestTimes bt = new BestTimes();
        System.out.println("Enter test case time in seconds: ");
        newTime = Double.parseDouble(input.nextLine());
        System.out.println(newTime);
        if (newTime >= bt.beginner[9].time){
            System.out.println("Sorry you did not make the top ten ranking. "
                + "Better luck next time!"
                + "\nWould you like to view the Best Times? 'Y' or 'N'");
                   char choice;
                    choice = (char) System.in.read();   
                    switch(choice) {
                        case 'Y':
                        case 'y': printBeginnerBestTimes();
                            break; //Return to main menu
                        case 'N':
                        case 'n': System.out.println("Break to main menu.");
                            break;
                    }
        }
        else updateBestTimes(newTime);
    
                    
        }
    
    public void updateBestTimes(double newBestTime) {
        BestTimes BestTimes = new BestTimes();
        BestTimesCalculator BestTimesCalculator = new BestTimesCalculator();
        int i;
        for (i = 0; i <10; i++){
            if (newBestTime < BestTimes.beginner[i].time) {
                for (int j = 9; j > i; j--){ //j is value being replaced.
                    BestTimesCalculator.changeBestTimeValues(j, BestTimes.beginner[j-1].playerName
                            , BestTimes.beginner[j-1].time);
                }
                BestTimesCalculator.changeBestTimeValues(i, playerName, newBestTime);
                break;
            }
        }
        
    }
    public void changeBestTimeValues(int index, String newPlayerName, double newTime){        
        BestTimes BestTimes = new BestTimes();
        BestTimes.beginner[index].playerName = newPlayerName;
        BestTimes.beginner[index].time = newTime;
        System.out.println("Beginner Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(BestTimes.beginner[i].ranking + "." + "\t" 
                        +  BestTimes.beginner[i].playerName + "\t\t"
                        + ((int) BestTimes.beginner[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) BestTimes.beginner[i].time%60));      //Seconds
            }
    }
        
}
