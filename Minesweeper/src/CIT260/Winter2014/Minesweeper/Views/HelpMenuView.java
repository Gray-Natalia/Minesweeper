/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.Winter2014.Minesweeper.Views;

import CIT260.Winter2014.Minesweeper.Controls.HelpMenuControl;

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
        super(HelpMenuView.menuItems);
    } 
    
    @Override
   public void executeCommands() {
        String command;
        
        do {
            display("Help Menu"); // display the menu
            
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
