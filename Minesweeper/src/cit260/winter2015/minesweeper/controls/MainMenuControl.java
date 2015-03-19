/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.controls;

import cit260.winter2015.minesweeper.views.BestTimesMenuView;
import cit260.winter2015.minesweeper.views.DifficultyLevelMenuView;
import java.io.Serializable;
import cit260.winter2015.minesweeper.GetPlayerName;
import cit260.winter2015.minesweeper.GetPlayerName;
import cit260.winter2015.minesweeper.views.HelpMenuView;

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
        chooseLevelMenuView.executeCommands();
    }

    public static void viewBestTimes() {
        BestTimesMenuView bestTimesMenuView = new BestTimesMenuView();
        bestTimesMenuView.executeCommands();
    }
    
    public static void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.executeCommands();
    }
    
}
