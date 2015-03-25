/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.views;

import cit260.winter2015.minesweeper.controls.HelpMenuControl;
import cit260.winter2015.minesweeper.exceptions.MenuException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group, Alfonso Ramirez
 * 
 */
public class HelpMenuView extends Menu {
        
    private final static String[][] menuItems = {
        {"P", "How to Play"},
        {"S", "Basic Strategies"}, 
        {"A", "About the Developers"},
        {"X", "Exit to Main Menu"}
    };
    private static final long serialVersionUID = 1L;
    
    // Create instance of the HelpMenuControl (action) class
    private final HelpMenuControl helpMenuControl = new HelpMenuControl();
    
    // default constructor
    public HelpMenuView() {
        super("Help Menu", HelpMenuView.menuItems);
    } 
    
    @Override
   public void executeCommands() {
        String command = null;
        
        do {
            display(); // display the menu
            try {
                command = getInput();
            } catch (MenuException ex) {
            }
            
            switch (command) {
                
                case "P":
                    helpMenuControl.displayHowToPlay();
                    break;
                case "S":
                    helpMenuControl.displayBasicStrategies();
                    break;
                case "A":
                    helpMenuControl.displayAbout();
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
