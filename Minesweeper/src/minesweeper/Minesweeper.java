/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import CIT260.Winter2014.Minesweeper.Views.MainMenuView;

/**
 *
 * @author kalavic
 */
public class Minesweeper {
    public static void main(String[] args) {
        
        System.out.println("   _____  .__                                                                 \n" +
"  /     \\ |__| ____   ____   ________  _  __ ____   ____ ______   ___________ \n" +
" /  \\ /  \\|  |/    \\_/ __ \\ /  ___/\\ \\/ \\/ // __ \\_/ __ \\\\____ \\_/ __ \\_  __ \\\n" +
"/    Y    \\  |   |  \\  ___/ \\___ \\  \\     /\\  ___/\\  ___/|  |_> >  ___/|  | \\/\n" +
"\\____|__  /__|___|  /\\___  >____  >  \\/\\_/  \\___  >\\___  >   __/ \\___  >__|   \n" +
"        \\/        \\/     \\/     \\/              \\/     \\/|__|        \\/       ");
        
        MainMenuView mainmenu = new MainMenuView();
        mainmenu.executeCommands();
    }
}
