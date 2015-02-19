/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Keith Banner
 */
public class MainMenuControl {
    
    
     
    public void play() {
        //Natalia Gray added chooseLevel
        GetPlayerName getPlayerName = new GetPlayerName();
        getPlayerName.getName();
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
