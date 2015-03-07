/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author Keith Banner
 * convert to java bean by C Rubenstein
 */
public class MainMenuControl implements Serializable {
     
    public static void play() {
        //Natalia Gray added chooseLevel
        GetPlayerName getPlayerName = new GetPlayerName();
        getPlayerName.getName();
        DifficultyLevelMenuView chooseLevelMenuView = new DifficultyLevelMenuView();
        chooseLevelMenuView.getInput();
    }

    public static void viewBestTimes() {
        BestTimesMenuView bestTimesMenuView = new BestTimesMenuView();
        bestTimesMenuView.getInput();
    }
    
    public static void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.getInput();
    }
    
}
