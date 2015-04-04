/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.menuViews;

import cit260.winter2015.minesweeper.exceptions.EndGameException;
import cit260.winter2015.minesweeper.menuControls.HelpMenuControl;

/**
 *
 * @author Group, Alfonso Ramirez
 *
 */
public class HelpMenuView extends Menu {

    private final static String[][] menuItems = {
        {"P", "How to Play"},
        {"S", "Basic Strategies"},
        {"A", "About the Developers"},
        {"X", "Exit to Main Menu"}
    };
    private static final long serialVersionUID = 1L;

    // Create instance of the HelpMenuControl (action) class
    private final HelpMenuControl helpMenuControl = new HelpMenuControl();

    // default constructor
    public HelpMenuView() {
        super("Help Menu", HelpMenuView.menuItems);
    }

    @Override
    public void executeCommands()throws EndGameException {
        String command;

        do {
            display(); // display the menu

            command = getInput();

            switch (command) {

                case "P":
                    HelpMenuControl.displayHowToPlay();
                    break;
                case "S":
                    HelpMenuControl.displayBasicStrategies();
                    break;
                case "A":
                    HelpMenuControl.displayAbout();
                    break;
                case "X":
                    break;
                default:
                    System.out.println("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("X"));
    }
}
