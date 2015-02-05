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


public class BestTimesMenuView {
        
    private static final String[][] menuItems = {
        {"1", "Beginner"},
        {"2", "Intermediate"},
        {"3", "Expert"},
        {"B", "Back to Main Menu"}
    }; 
  
    BestTimesMenuControl bestTimesMenuControl = new BestTimesMenuControl();
    
    public BestTimesMenuView() {

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
                case "1":
                    this.bestTimesMenuControl.beginnerBestTimes();
                    break;
                case "2":
                    this.bestTimesMenuControl.intermediateBestTimes();
                    break;
                case "3":
                    this.bestTimesMenuControl.expertBestTimes();            
                    break;
                case "B":
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command.");
                    continue;                    
            }
        } while (!command.equals("B"));

        return;
    }
    

    
    
   public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tBest Times");
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < BestTimesMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }   
    
}
