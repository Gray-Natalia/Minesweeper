/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;
import static minesweeper.HighScores.changeHighScoreValues;
import static minesweeper.PrintHighScores.printBeginnerHighScores;

/**
 *
 * @author Keith Banner, Nikki Huntsman
 */


public class HighScoreCalculator {        
    public static void main(String args[])   
        throws java.io.IOException{
        HighScoreCalculator hsc = new HighScoreCalculator();
        Name n = new Name();
        n.getName();
        hsc.checkHighScoreEligibility();
    }
    public double newScore;
    
    public void checkHighScoreEligibility()    
        throws java.io.IOException{
        Scanner input = new Scanner(System.in);
        HighScores hs = new HighScores();
        System.out.println("Enter test case time in seconds: ");
        newScore = Double.parseDouble(input.nextLine());
        System.out.println(newScore);
        if (newScore >= hs.beginner[9].time){
            System.out.println("Sorry you did not make the top ten ranking. "
                + "Better luck next time!"
                + "\nWould you like to view the High Scores? 'Y' or 'N'");
                   char choice;
                    choice = (char) System.in.read();   
                    switch(choice) {
                        case 'Y':
                        case 'y': printBeginnerHighScores();
                        case 'N':
                        case 'n': System.out.println("Break to main menu.");
                            break;
                    }
        }
        else updateHighScores(newScore);
    
                    
        }
    
    public static void updateHighScores(double newHighScore) {
        printBeginnerHighScores();
        HighScores hs = new HighScores();
        Name n = new Name();
        int i;
        for (i = 0; i <10; i++){
            if (newHighScore < hs.beginner[i].time) {
                for (int j = 9; j > i; j--){ //j is value being replaced.
                    changeHighScoreValues(j, hs.beginner[j-1].playerName
                            , hs.beginner[j-1].time);
                }
                changeHighScoreValues(i, n.name, newHighScore);
                
            }
        }
    }
        
}
