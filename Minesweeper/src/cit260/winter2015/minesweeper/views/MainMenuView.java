/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.views;

import cit260.winter2015.minesweeper.controls.MainMenuControl;
import cit260.winter2015.minesweeper.exceptions.EndGameException;
import cit260.winter2015.minesweeper.exceptions.MenuException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MainMenuView extends Menu {
    
    private static final String[][] menuItems = {
        {"P", "Play"},
        {"V", "View Best Times"},
        {"H", "Help"},
        {"X", "Exit Minesweeper"}
    }; 
    private static final long serialVersionUID = 1L;
  
    public MainMenuView() {
        super("Main Menu", MainMenuView.menuItems);
    }
    
    @Override
    public void executeCommands() {    
        String command = null;
        
        do {
            display();

            try {
                command = getInput();
            } catch (MenuException e) {
            }
                
            try {
            if (!command.equals("P") || !"V".equals(command)
                    || !"H".equals(command) || !"X".equals(command)) {
                throw new MenuException();
            }
            } catch (MenuException ex) {
                System.err.println("Invalid command. Please enter a valid command.");
            }
            
            switch (command) {
                //Natalia Gray added chooseLevel
                case "P": {
                    try {
                        MainMenuControl.play();
                    } catch (EndGameException ex) {
                        break;
                    }
                }
                break;
                case "V":
                    MainMenuControl.viewBestTimes();
                    break;
                case "H":
                    MainMenuControl.displayHelpMenu();
                    break;
                case "X":
                    break;
//                default: 
//                    System.out.println("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("X"));
    }
}