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


public class GameMenuView implements Serializable{
    
    private static final String[][] menuItems = {
        {"R", "Reveal Cell"},
        {"F", "Flag Cell"},
        {"?", "Mark Unknown"},
        {"X", "Exit to Main Menu (Game progress will be lost.)"}
    }; 
  
    public GameMenuView() {

    }
    
    public static void getInput() {       

        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            GameMenuView.display(); // display the menu

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
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
    
   public static final void display() {
        CellManager cm = new CellManager();
        cm.displayBoard();
        System.out.println("\n\t===============================================================");
        System.out.println("\tGame Menu");
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < GameMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }   
    
}
