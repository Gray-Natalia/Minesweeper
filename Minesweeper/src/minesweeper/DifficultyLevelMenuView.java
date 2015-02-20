/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author kalavic
 */
public class DifficultyLevelMenuView {
    private final static String[][] menuItems = {
        {"B", "Beginner"},
        {"I", "Intermediate"}, 
        {"E", "Expert"},
        {"P", "Preset Demo"},
        {"X", "Exit To Main Menu"}
    };
    
    // Create instance of the DifficultyLevelMenuControl (action) class
    private DifficultyLevelMenuControl chooseLevelMenuControl = new DifficultyLevelMenuControl();
    
    // default constructor
    public DifficultyLevelMenuView() {
        
    } 
    
    // display the level menu and get the end users input selection
    public void getInput() {       
              
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            
            this.display(); // display the menu
            
            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "B":
                    chooseLevelMenuControl.beginner();
                    break;
                case "I":
                    chooseLevelMenuControl.intermediate();
                    break;
                case "E":
                    chooseLevelMenuControl.expert();
                    break;
                case "P":
                    chooseLevelMenuControl.beginnerPreset();
                    break;
                case "X":
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("X"));  
        
    }

        // displays the level menu
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tLevel Menu");
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following levels:");

        for (int i = 0; i < DifficultyLevelMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
}
