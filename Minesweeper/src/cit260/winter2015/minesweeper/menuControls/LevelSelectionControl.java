/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.menuControls;

import java.io.Serializable;
import cit260.winter2015.minesweeper.CellManager;
import cit260.winter2015.minesweeper.GameVariables;
import cit260.winter2015.minesweeper.enums.LevelType;
import cit260.winter2015.minesweeper.menuViews.GameMenuView;
import cit260.winter2015.minesweeper.MineManager;
import static cit260.winter2015.minesweeper.enums.LevelType.BEGINNER;
import cit260.winter2015.minesweeper.exceptions.EndGameException;

/**
 *
 * @author kalavic
 * convert to java beans by C Rubenstein
 */
public class LevelSelectionControl implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    public LevelSelectionControl() {
        
    }
    
    public static void beginner() throws EndGameException {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();
        LevelType.setBeginner();
        displaySelectedLevel();
        startSelectedLevel();
    }
        
    public static void intermediate() throws EndGameException {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();
        LevelType.setIntermediate();
        displaySelectedLevel();
        startSelectedLevel();
    }
            
    public static void expert() throws EndGameException {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();
        LevelType.setExpert();
        displaySelectedLevel();
        startSelectedLevel();
    }
    
    public static void beginnerPreset() throws EndGameException {
        System.out.println();
        displayHelpBorder();  
        System.out.println("\tThis is a special preset board for testing the game.");
        displayHelpBorder();
        GameVariables.setGameVariables("Preset", BEGINNER.getRows(), BEGINNER.getColumns(), BEGINNER.getMines());
        MineManager mm = new MineManager();
        mm.presetMines();
        CellManager cm = new CellManager();
        cm.calculateCellValues();
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.executeCommands();
        
    }
    
    private static void displayHelpBorder() {       
        System.out.println(
        "\t===============================================================");
    }
    
    private static void displaySelectedLevel() {
        System.out.println("\tYou have selected " + GameVariables.getDifficultyLevel() + "."
                + "\n\tThere are " + GameVariables.getNumberOfRows() + " rows,"
                + "\n\t" + GameVariables.getNumberOfColumns() + " columns,"
                + "\n\tand " + GameVariables.getNumberOfMines() + " mines.");
        displayHelpBorder();
    }
    
    private static void startSelectedLevel() throws EndGameException {
        MineManager mm = new MineManager();
        mm.generateMines();
        CellManager cm = new CellManager();
        cm.calculateCellValues();
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.executeCommands();
    }
}