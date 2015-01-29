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
    public static void main(String args[])   
        throws java.io.IOException{
        HighScoreCalculator hsc = new HighScoreCalculator();
        Name n = new Name();
        n.getName();
        hsc.checkHighScoreEligibility();
    }
    public int newScore;
    
    public void checkHighScoreEligibility()    
        throws java.io.IOException{
        HighScores hs = new HighScores();
        System.out.println("Enter test case time in seconds: ");
        newScore = System.in.read();
        if (newScore > hs.beginner[9].time){
        System.out.println("Sorry you did not make the top ten ranking. Please try again.");
        }             
    }
    //public static void main(String args[]) {
        //double currentScore;
        //currentScore = 60;
        //int i;
        //for (i = 0; i <10; i++)
            //if currentScore < HighScores.HighScoreBeginner(i)
    //}
}
