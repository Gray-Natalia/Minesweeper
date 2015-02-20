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
public class DifficultyLevelMenuControl {
    
    public DifficultyLevelMenuControl() {
        
    } 
    
    public int numberOfMines;
    public int numberOfColumns;
    public int numberOfRows;
    public int numberOfCells;
    public String difficultyLevel;

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
        numberOfMines = 10;
        numberOfColumns = 9;
        numberOfRows = 9;
        difficultyLevel = "Beginner";
        System.out.println("\tThis is a special preset board for testing the game.");
        displayHelpBorder();
        CellNumberCalculatorPreset cellNumberCalculator = new CellNumberCalculatorPreset();
        cellNumberCalculator.calculateNumMines();
    }
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public void displayAndStartSelectedLevel() {
        System.out.println("\tYou have selected " + difficultyLevel + "."
                + "\n\tThere are " + numberOfRows + " rows,"
                + "\n\t" + numberOfColumns + " columns,"
                + "\n\tand " + numberOfMines + " mines.");
        displayHelpBorder();
        CellNumberCalculatorRandom cellNumberCalculator = new CellNumberCalculatorRandom();
        cellNumberCalculator.calculateNumMines(numberOfColumns, numberOfRows, numberOfMines);
    }
    
}
