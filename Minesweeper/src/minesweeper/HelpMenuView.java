/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;
import java.io.Serializable;

/**
 *
 * @author Group, Alfonso Ramirez
 * 
 */
public class HelpMenuView implements Serializable {
        
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
        
    } 
    
    // display the help menu and get the end users input selection
    public void getInput() {       
              
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            
            HelpMenuView.display(); // display the menu
            
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
                case "X":
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("X"));  
        
         return;
    }

        // displays the help menu
    private static void display() {
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
