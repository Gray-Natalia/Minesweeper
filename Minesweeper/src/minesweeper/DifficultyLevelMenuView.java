/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
/**
 *
 * @author kalavic
 */


public class DifficultyLevelMenuView extends Menu {
    private final static String[][] menuItems = {
        {"B", "Beginner"},
        {"I", "Intermediate"}, 
        {"E", "Expert"},
        {"P", "Preset Demo"},
        {"X", "Exit To Main Menu"}
    };
    
    DifficultyLevelMenuControl difficultyLevelMenuControl = new DifficultyLevelMenuControl();
    
    public DifficultyLevelMenuView() {
        super(DifficultyLevelMenuView.menuItems);
    }
    
    @Override
   public void executeCommands() {
        String command;
        
        do {
            display("Difficulty Level Menu"); // display the menu
            
            command = getCommand();
            
            switch (command) {
                case "B":
                    difficultyLevelMenuControl.beginner();
                    break;
                case "I":
                    difficultyLevelMenuControl.intermediate();
                    break;
                case "E":
                    difficultyLevelMenuControl.expert();
                    break;
                case "P":
                    difficultyLevelMenuControl.beginnerPreset();
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
