/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.menuViews;

import cit260.winter2015.minesweeper.GameVariables;
import cit260.winter2015.minesweeper.menuControls.GameMenuControl;
import cit260.winter2015.minesweeper.exceptions.EndGameException;



public class GameMenuView extends Menu {
    
    private static final String[][] menuItems = {
        {"C", "Click: Reveal Cell"},
        {"R", "Right Click: Flag Cell, Mark Unknown"},
        {"T", "Two Button Click: Reveals all cells touching"},
        {"X", "Exit to Main Menu (Game progress will be lost.)"}
    }; 
    private static final long serialVersionUID = 1L;
  
    public GameMenuView() {
        super("Game Menu", GameMenuView.menuItems);
    }
    
    @Override
    public void executeCommands() throws EndGameException{
        String command;
        
        do {
            cit260.winter2015.minesweeper.CellManager cm = new cit260.winter2015.minesweeper.CellManager();
            // Display current board state.
            cm.setStatusBarMinesRemaining();
            cm.displayBoardState();
            display(); // display the menu
            
            command = getInput();
            
            switch (command) {
                //Natalia Gray added chooseLevel
                case "C":
                    GameMenuControl.click();
                    break;
                case "R":
                    GameMenuControl.rightClick();
                    break;
                case "T":
                    GameMenuControl.twoButtonClick();
                    break;
                case "X":
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("X"));
    }
}
