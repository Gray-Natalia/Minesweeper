/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kalavic
 * convert to java bean by C Rubenstein
 */
public class Game implements Serializable {
    //Instancevariables variables
    private String level;
    private int squares;
    private int mines;
    
    public Game(String gameLevel, int squaresTotal, int minesTotal){
        level = gameLevel;
        squares = squaresTotal;
        mines = minesTotal;
    }

    public Game() {
        this.level = "beginner";
        this.squares = 81;
        this.mines = 10;
    }
    
          
    public void describeLevel(){
        System.out.println(level + " has " + squares + " squares and " + mines + " mines.");
                
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSquares() {
        return squares;
    }

    public void setSquares(int squares) {
        this.squares = squares;
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.level);
        hash = 53 * hash + this.squares;
        hash = 53 * hash + this.mines;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        if (this.squares != other.squares) {
            return false;
        }
        if (this.mines != other.mines) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "level=" + level + ", squares=" + squares + ", mines=" + mines + '}';
    }

    
}
