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
    
    public void checkBestTimeEligibility() throws java.io.IOException {
        GetPlayerName getPlayerName = new GetPlayerName();
        double newTime;
        String playerName = getPlayerName.getName();
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
        GetPlayerName getPlayerName = new GetPlayerName();
        int i;
        for (i = 0; i <10; i++){
            if (newBestTime < BestTimes.beginner[i].time) {
                for (int j = 9; j > i; j--){ //j is value being replaced.
                    BestTimesCalculator.changeBestTimeValues(j, BestTimes.beginner[j-1].playerName
                            , BestTimes.beginner[j-1].time);
                }
                BestTimesCalculator.changeBestTimeValues(i, getPlayerName.playerName, newBestTime);
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
        double total;
        switch (difficultyLevel) {
            case "beginner":
                total = 0;
                for (BestTimes beginner : bestTimes.beginner) {
                    total += beginner.time;
                }
                double beginnerAverage = total / bestTimes.beginner.length;
                functionAverage = beginnerAverage;
                break;
            case "intermediate":
                total = 0;
                for (BestTimes intermediate : bestTimes.intermediate) {
                    total += intermediate.time;
                }
                double intermediateAverage = total / bestTimes.intermediate.length;
                functionAverage = intermediateAverage;
                break;
            case "expert":
                total = 0;
                for (BestTimes expert : bestTimes.expert) {
                    total += expert.time;
                }
                double expertAverage = total / bestTimes.expert.length;
                functionAverage = expertAverage;
                break;
            default:
                System.out.println("Invalid input received on average time function."
                        + "Contact the developer for help.");
        }
        return functionAverage;
    }
    
    // Converts Time from seconds to ## seconds or ##:## if option is 1
    // If option is not 1 seconds become ##:##
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
