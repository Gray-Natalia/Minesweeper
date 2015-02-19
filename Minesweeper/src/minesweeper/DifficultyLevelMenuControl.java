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
    
    int numberOfMines;
    int numberOfColumns;
    int numberOfRows;
    int numberOfCells;
    String difficultyLevel;

    public void displayBeginner() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        this.displayHelpBorder();             
        numberOfMines = 10;
        numberOfColumns = 9;
        numberOfRows = 9;
        numberOfCells = numberOfColumns * numberOfRows;
        difficultyLevel = "Beginner";
        displaySelectedLevel();
        displayHelpBorder();
    }
        
    public void displayIntermediate() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();     
        numberOfMines = 40;
        numberOfColumns = 16;
        numberOfRows = 16;
        numberOfCells = numberOfColumns * numberOfRows;
        difficultyLevel = "Intermediate";
        displaySelectedLevel();
        displayHelpBorder();
    }
            
    public void displayExpert() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();     
        numberOfMines = 99;
        numberOfColumns = 30;
        numberOfRows = 16;
        numberOfCells = numberOfColumns * numberOfRows;
        difficultyLevel = "Expert";
        displaySelectedLevel();
        displayHelpBorder();
    }
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public void displaySelectedLevel() {
        System.out.println("\tYou have selected " + difficultyLevel + "."
                + "\n\tThere are " + numberOfRows + " rows,"
                + "\n\t" + numberOfColumns + " columns,"
                + "\n\tand " + numberOfMines + " mines."
                + "\n\tThat's " + numberOfCells + " cells!");
    }
    
}
