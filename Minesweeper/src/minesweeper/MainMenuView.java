/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Keith Banner
 */


public class MainMenuView extends Menu {
    
    private static final String[][] menuItems = {
        {"P", "Play"},
        {"V", "View Best Times"},
        {"H", "Help"},
        {"X", "Exit Minesweeper"}
    }; 
  
    public MainMenuView() {
        super(MainMenuView.menuItems);
    }
    
    @Override
    public void executeCommands() {    
        String command;
        
        do {
            display("Main Menu");

            command = getCommand();
            
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
}
