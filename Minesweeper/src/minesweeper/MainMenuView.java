/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author Keith Banner
 */


public class MainMenuView {
    
    private static final String[][] menuItems = {
        {"P", "Play"},
        {"V", "View Best Times"},
        {"H", "Help"},
        {"X", "Exit Minesweeper"}
    }; 
  
    MainMenuControl mainMenuControl = new MainMenuControl();
    
    public MainMenuView() {

    }
 
    
    public void getInput() {       

        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display(); // display the menu

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                //Natalia Gray added chooseLevel
                case "P":
                    mainMenuControl.chooseLevel();
                    break;
                case "V":
                    mainMenuControl.viewBestTimes();
                    break;
                case "H":
                    mainMenuControl.displayHelpMenu();            
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
    

    
    
   public final void display() {
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
