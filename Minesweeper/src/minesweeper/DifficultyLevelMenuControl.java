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
 * convert to java beans by C Rubenstein
 */
public class DifficultyLevelMenuControl implements Serializable  {
    
    public DifficultyLevelMenuControl() {
        
    } 
    
    private int numberOfColumns;
    private int numberOfRows;
    private int numberOfMines;
    private String difficultyLevel;
    
    public void beginner() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        this.displayHelpBorder();
        numberOfMines = 10;
        numberOfColumns = 9;
        numberOfRows = 9;
        difficultyLevel = "Beginner";
        displayAndStartSelectedLevel();
    }
        
    public void intermediate() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();
        numberOfMines = 40;
        numberOfColumns = 16;
        numberOfRows = 16;
        difficultyLevel = "Intermediate";
        displayAndStartSelectedLevel();
    }
            
    public void expert() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();
        numberOfMines = 99;
        numberOfColumns = 30;
        numberOfRows = 16;
        difficultyLevel = "Expert";
        displayAndStartSelectedLevel();
    }
    
    public void beginnerPreset() {
        System.out.println();
        this.displayHelpBorder();  
        System.out.println("\tThis is a special preset board for testing the game.");
        displayHelpBorder();
        CellNumberCalculatorPreset cellNumberCalculatorPreset = new CellNumberCalculatorPreset();
        cellNumberCalculatorPreset.calculateNumMines();
    }
    
    public static void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public void displayAndStartSelectedLevel() {
        System.out.println("\tYou have selected " + difficultyLevel + "."
                + "\n\tThere are " + numberOfRows + " rows,"
                + "\n\t" + numberOfColumns + " columns,"
                + "\n\tand " + numberOfMines + " mines.");
        displayHelpBorder();
        
        CellNumberCalculatorPreset cellNumberCalculator = new CellNumberCalculatorPreset();
        cellNumberCalculator.calculateNumMines();
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.numberOfColumns;
        hash = 29 * hash + this.numberOfRows;
        hash = 29 * hash + this.numberOfMines;
        hash = 29 * hash + Objects.hashCode(this.difficultyLevel);
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
        final DifficultyLevelMenuControl other = (DifficultyLevelMenuControl) obj;
        if (this.numberOfColumns != other.numberOfColumns) {
            return false;
        }
        if (this.numberOfRows != other.numberOfRows) {
            return false;
        }
        if (this.numberOfMines != other.numberOfMines) {
            return false;
        }
        if (!Objects.equals(this.difficultyLevel, other.difficultyLevel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DifficultyLevelMenuControl{" + "numberOfColumns=" + numberOfColumns + ", numberOfRows=" + numberOfRows + ", numberOfMines=" + numberOfMines + ", difficultyLevel=" + difficultyLevel + '}';
    }
    
}
