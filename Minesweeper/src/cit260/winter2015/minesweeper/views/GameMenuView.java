/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.views;

import cit260.winter2015.minesweeper.controls.GameMenuControl;

/**
 *
 * @author Keith Banner
 */


public class GameMenuView extends Menu {
    
    private static final String[][] menuItems = {
        {"R", "Reveal Cell"},
        {"F", "Flag Cell"},
        {"?", "Mark Unknown"},
        {"X", "Exit to Main Menu (Game progress will be lost.)"}
    }; 
    private static final long serialVersionUID = 1L;
  
    public GameMenuView() {
        super("Game Menu", GameMenuView.menuItems);
    }
    
    @Override
    public void executeCommands() {
        String command;
        
        do {
            cit260.winter2015.minesweeper.CellManager cm = new cit260.winter2015.minesweeper.CellManager();
            // Display current board state.
            cm.displayBoard();
            display(); // display the menu
            command = getInput();
            
            switch (command) {
                //Natalia Gray added chooseLevel
                case "R":
                    GameMenuControl.reveal();
                    break;
                case "F":
                    GameMenuControl.flag();
                    break;
                case "?":
                    GameMenuControl.unknown();            
                    break;
                case "X":
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("X"));
    }
}
