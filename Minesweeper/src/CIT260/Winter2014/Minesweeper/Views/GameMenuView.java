/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.Winter2014.Minesweeper.Views;

import CIT260.Winter2014.Minesweeper.Controls.GameMenuControl;

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
  
    public GameMenuView() {
        super(GameMenuView.menuItems);
    }
    
    @Override
    public void executeCommands() {
        String command;
        
        do {
            display("Game Menu"); // display the menu
            
            command = getCommand();
            
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
                    continue;                    
            }
        } while (!command.equals("X"));
    }
}
