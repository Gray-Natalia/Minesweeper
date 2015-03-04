/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author cheryl
 */
public class BestTimesPrint implements Serializable{
    
    public static void printBeginnerBestTimes() {   
        BestTimes bestTimes = new BestTimes();
        System.out.println("Beginner Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i < 10; i++) {
                System.out.println(bestTimes.beginner[i].ranking + "." + "\t" 
                        +  bestTimes.beginner[i].playerName + "\t\t"
                        +  BestTimesCalculator.convertTime(bestTimes.beginner[i].time, 0));      //Seconds
            }
            System.out.println("The top 10 average time for beginner difficulty is " + 
                    BestTimesCalculator.convertTime(BestTimesCalculator.calculateAverageTime("beginner"), 1)); // option 1 for print type.
            
    }
    public static void printIntermediateBestTimes() {   
        BestTimes bestTimes = new BestTimes();
        System.out.println("Intermediate Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bestTimes.intermediate[i].ranking + "." + "\t" 
                        +  bestTimes.intermediate[i].playerName + "\t\t"
                        +  BestTimesCalculator.convertTime(bestTimes.intermediate[i].time, 0));      //Seconds
            }
            System.out.println("The top 10 average time for intermediate difficulty is " + 
                    BestTimesCalculator.convertTime(BestTimesCalculator.calculateAverageTime("intermediate"), 1));
    }    
    public static void printExpertBestTimes() {   
        BestTimes bestTimes = new BestTimes();
        System.out.println("Expert Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bestTimes.expert[i].ranking + "." + "\t" 
                        +  bestTimes.expert[i].playerName + "\t\t"
                        +  BestTimesCalculator.convertTime(bestTimes.expert[i].time, 0));      //Seconds
            }
            System.out.println("The top 10 average time for expert difficulty is " + 
                    BestTimesCalculator.convertTime(BestTimesCalculator.calculateAverageTime("expert"), 1));
    }    

}
