/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.views;

import cit260.winter2015.minesweeper.Menu;
import cit260.winter2015.minesweeper.controls.HelpMenuControl;

/**
 *
 * @author Group, Alfonso Ramirez
 * 
 */
public class HelpMenuView extends Menu {
        
    private final static String[][] menuItems = {
        {"P", "How to Play"},
        {"S", "Basic Strategies"}, 
        {"A", "About"},
        {"X", "Exit to Main Menu"}
    };
    
    // Create instance of the HelpMenuControl (action) class
    private HelpMenuControl helpMenuControl = new HelpMenuControl();
    
    // default constructor
    public HelpMenuView() {
        super("Help Menu", HelpMenuView.menuItems);
    } 
    
    @Override
   public void executeCommands() {
        String command;
        
        do {
            display(); // display the menu
            
            command = getCommand();
            
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
