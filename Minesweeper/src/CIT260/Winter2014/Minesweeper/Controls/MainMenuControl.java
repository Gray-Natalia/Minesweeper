/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.Winter2014.Minesweeper.Controls;

import CIT260.Winter2014.Minesweeper.Views.HelpMenuView;
import CIT260.Winter2014.Minesweeper.Views.DifficultyLevelMenuView;
import CIT260.Winter2014.Minesweeper.Views.BestTimesMenuView;
import java.io.Serializable;
import minesweeper.GetPlayerName;

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
