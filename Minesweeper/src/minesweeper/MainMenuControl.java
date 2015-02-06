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
public class MainMenuControl {
    
    
     
    public void chooseLevel() {
        //Natalia Gray added chooseLevel
        ChooseLevelMenuView chooseLevelMenuView = new ChooseLevelMenuView();
        chooseLevelMenuView.getInput();
    }

    public void viewBestTimes() {
        BestTimesMenuView bestTimesMenuView = new BestTimesMenuView();
        bestTimesMenuView.getInput();
    }
    
    public void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.getInput();
    }
    
}
