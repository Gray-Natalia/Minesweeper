/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Keith Banner, Nikki Huntsman
 */
public class HighScoreCalculator {

    public void CheckScore(){
        
        if (newScore > time[9]){
        system.out.println("Sorry you did not make the top ten ranking. Please try again.");
        break; 
        }             
    }
    public static void main(String args[]) {
        double currentScore;
        currentScore = 60;
        int i;
        for (i = 0; i <10; i++)
            if currentScore < HighScoreBeginner.HighScoreBeginner(i)
    }
}
