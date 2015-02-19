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
    public static void main(String args[]) {
    }
    public double newTime;
    
    Name Name = new Name();
    public String playerName;
    
    public void checkBestTimeEligibility() throws java.io.IOException {
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
        BestTimes bestTimes = new BestTimes();
        bestTimes.beginner[index].playerName = newPlayerName;
        bestTimes.beginner[index].time = newTime;
        System.out.println("Beginner Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i < bestTimes.beginner.length; i++) {
                System.out.println(bestTimes.beginner[i].ranking + "." + "\t" 
                        +  bestTimes.beginner[i].playerName + "\t\t"
                        + ((int) bestTimes.beginner[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) bestTimes.beginner[i].time%60));      //Seconds
            }
    }
    
    
    public double functionAverage;
    
    /**
     *
     * @param difficultyLevel
     * @return
     */
    public double calculateAverageTime(String difficultyLevel) {
        BestTimes bestTimes = new BestTimes();
        double total = 0;
        if (difficultyLevel.equalsIgnoreCase("beginner")) {
            for (BestTimes beginner : bestTimes.beginner) {
                total += beginner.time;
            }
            double beginnerAverage = total / bestTimes.beginner.length;
            functionAverage = beginnerAverage;
        }
        if (difficultyLevel.equalsIgnoreCase("intermediate")) {
            for (BestTimes intermediate : bestTimes.intermediate) {
                total += intermediate.time;
            }
            double intermediateAverage = total / bestTimes.intermediate.length;
            functionAverage = intermediateAverage;
        }
        if (difficultyLevel.equalsIgnoreCase("expert")) {
            for (BestTimes expert : bestTimes.expert) {
                total += expert.time;
            }
            double expertAverage = total / bestTimes.expert.length;
            functionAverage = expertAverage;
        }
        return functionAverage;
    }
    
    // Converts Time from seconds to ## seconds or ##:## if option is 1
    // or just to ##:##
    public String convertTime(double time, int option) {
        String output;
            if (time < 60 && option == 1) {
            output = (String.format("%.2f", time) + " seconds");
        }
        else {
            output = (((int) time/60) + ":" + String.format("%02d",(int) time%60));
        }
        return output;
    }

      
}
