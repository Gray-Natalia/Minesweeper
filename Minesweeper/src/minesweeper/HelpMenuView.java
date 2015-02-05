/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;



/**
 *
 * @author Group
 */
public class HelpMenuView  {
        
    private final static String[][] menuItems = {
        {"P", "How to Play"},
        {"S", "Basic Strategies"}, 
        {"A", "About"},
        {"B", "Back"}
    };
    
    // Create instance of the HelpMenuControl (action) class
    private HelpMenuControl helpMenuControl = new HelpMenuControl();
    
    // default constructor
    public HelpMenuView() {
        
    } 
    
    // display the help menu and get the end users input selection
    public void getInput() {       
              
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            
            this.display(); // display the menu
            
            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
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
                case "B":
//                    Will go back to future MainMenu class
//                    mm.MainMenu();
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("B"));  
        
         return;
    }

        // displays the help menu
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tHelp Menu");
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < HelpMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
  
}
