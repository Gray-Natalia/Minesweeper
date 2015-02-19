/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
/**
 *
 * @author cheryl
 */
public class BestTimesPrint {
    
    public static void printBeginnerBestTimes() {   
        BestTimes bestTimes = new BestTimes();
        BestTimesCalculator bestTimesCalculator = new BestTimesCalculator();
        System.out.println("Beginner Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bestTimes.beginner[i].ranking + "." + "\t" 
                        +  bestTimes.beginner[i].playerName + "\t\t"
                        +  bestTimesCalculator.convertTime(bestTimes.beginner[i].time, 0));      //Seconds
            }
            System.out.println("The top 10 average time for beginner difficulty is " + 
                    bestTimesCalculator.convertTime(bestTimesCalculator.calculateAverageTime("beginner"), 1)); // option 1 for print type.
            
    }
    public static void printIntermediateBestTimes() {   
        BestTimes bestTimes = new BestTimes();
        BestTimesCalculator bestTimesCalculator = new BestTimesCalculator();
        System.out.println("Intermediate Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bestTimes.intermediate[i].ranking + "." + "\t" 
                        +  bestTimes.intermediate[i].playerName + "\t\t"
                        +  bestTimesCalculator.convertTime(bestTimes.intermediate[i].time, 0));      //Seconds
            }
            System.out.println("The top 10 average time for intermediate difficulty is " + 
                    bestTimesCalculator.convertTime(bestTimesCalculator.calculateAverageTime("intermediate"), 1));
    }    
    public static void printExpertBestTimes() {   
        BestTimes bestTimes = new BestTimes();
        BestTimesCalculator bestTimesCalculator = new BestTimesCalculator();
        System.out.println("Expert Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bestTimes.expert[i].ranking + "." + "\t" 
                        +  bestTimes.expert[i].playerName + "\t\t"
                        +  bestTimesCalculator.convertTime(bestTimes.expert[i].time, 0));      //Seconds
            }
            System.out.println("The top 10 average time for expert difficulty is " + 
                    bestTimesCalculator.convertTime(bestTimesCalculator.calculateAverageTime("expert"), 1));
    }    

}
