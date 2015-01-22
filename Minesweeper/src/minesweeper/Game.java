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
    public int squeres;
    public int mines;
    
    public Game(String gameLevel, int squeresTotal, int minesTotal){
        level = gameLevel;
        squeres = squeresTotal;
        mines = minesTotal;
    }
    
          
    public void discribeLevel(){
        System.out.println(level + " has " + squeres + "squeres and " + mines + "mines.");
                
    }

    
}
