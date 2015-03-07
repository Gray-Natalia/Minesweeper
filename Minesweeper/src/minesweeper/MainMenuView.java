/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Keith Banner
 */


public class MainMenuView implements Serializable {
    
    private static final String[][] menuItems = {
        {"P", "Play"},
        {"V", "View Best Times"},
        {"H", "Help"},
        {"X", "Exit Minesweeper"}
    }; 
  
    public MainMenuView() {

    }
    
    public static void getInput() {       

        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            MainMenuView.display(); // display the menu

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                //Natalia Gray added chooseLevel
                case "P":
                    MainMenuControl.play();
                    break;
                case "V":
                    MainMenuControl.viewBestTimes();
                    break;
                case "H":
                    MainMenuControl.displayHelpMenu();            
                    break;
                case "X":
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command.");
                    continue;                    
            }
        } while (!command.equals("X"));
    }
    
   private static void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tMain Menu");
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < MainMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }   
    
}
