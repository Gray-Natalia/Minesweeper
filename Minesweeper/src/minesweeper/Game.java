/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author kalavic
 */
public class Game {
    //Instance variables
    public String level;
    public int squares;
    public int mines;
    
    public Game(String gameLevel, int squaresTotal, int minesTotal){
        level = gameLevel;
        squares = squaresTotal;
        mines = minesTotal;
    }
    
          
    public void describeLevel(){
        System.out.println(level + " has " + squares + "squares and " + mines + "mines.");
                
    }

    
}
