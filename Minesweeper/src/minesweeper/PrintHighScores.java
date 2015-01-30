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
public class PrintHighScores {
    public static void main(String[] args){
        printBeginnerHighScores();
        System.out.println("\n");
        printIntermediateHighScores();
        System.out.println("\n");
        printExpertHighScores();
    }    
    public static void printBeginnerHighScores() {   
        HighScores hs = new HighScores();
        System.out.println("Beginner High Score List" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(hs.beginner[i].ranking + "." + "\t" 
                        +  hs.beginner[i].playerName + "\t\t"
                        + ((int) hs.beginner[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) hs.beginner[i].time%60));      //Seconds
            }
    }
    public static void printIntermediateHighScores() {   
        HighScores hs = new HighScores();
        System.out.println("Intermediate High Score List" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(hs.intermediate[i].ranking + "." + "\t" 
                        +  hs.intermediate[i].playerName + "\t\t"
                        + ((int) hs.intermediate[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) hs.intermediate[i].time%60));      //Seconds
            }
    }    
    public static void printExpertHighScores() {   
        HighScores hs = new HighScores();
        System.out.println("Expert High Score List" + "\n" +
                 "Rank\tName\t\tTime");
            for (int i = 0; i <10; i++) {
                System.out.println(hs.expert[i].ranking + "." + "\t" 
                        +  hs.expert[i].playerName + "\t\t"
                        + ((int) hs.expert[i].time/60) + ":"  //Minutes
                        + String.format("%02d",(int) hs.expert[i].time%60));      //Seconds
            }
    }    

}
