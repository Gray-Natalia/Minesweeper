/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.menuViews;

import cit260.winter2015.minesweeper.menuControls.MainMenuControl;
import cit260.winter2015.minesweeper.exceptions.EndGameException;

public class MainMenuView extends Menu {

    private static final String[][] menuItems = {
        {"P", "Play"},
        {"V", "View Best Times"},
        {"H", "Help"},
        {"X", "Exit Minesweeper"}
    };
    private static final long serialVersionUID = 1L;

    public MainMenuView() {
        super("Main Menu", MainMenuView.menuItems);
    }

    @Override
    public void executeCommands() {
        String command;

        do {
            display();
            command = getInput();

            switch (command) {
                //Natalia Gray added chooseLevel
                case "P":
                    try {
                        MainMenuControl.play();
                    } catch (EndGameException ex) {
                        break;
                    }
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
            }
        } while (!command.equals("X"));
    }
}
