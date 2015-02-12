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
        System.out.println("Beginner Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bestTimes.beginner[i].ranking + "." + "\t" 
                        +  bestTimes.beginner[i].playerName + "\t\t"
                        + ((int) bestTimes.beginner[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) bestTimes.beginner[i].time%60));      //Seconds
            }
    }
    public static void printIntermediateBestTimes() {   
        BestTimes bt = new BestTimes();
        System.out.println("Intermediate Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bt.intermediate[i].ranking + "." + "\t" 
                        +  bt.intermediate[i].playerName + "\t\t"
                        + ((int) bt.intermediate[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) bt.intermediate[i].time%60));      //Seconds
            }
    }    
    public static void printExpertBestTimes() {   
        BestTimes bt = new BestTimes();
        System.out.println("Expert Best Times" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(bt.expert[i].ranking + "." + "\t" 
                        +  bt.expert[i].playerName + "\t\t"
                        + ((int) bt.expert[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) bt.expert[i].time%60));      //Seconds
            }
    }    

}
