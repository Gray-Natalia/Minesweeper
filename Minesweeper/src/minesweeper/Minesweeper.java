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
public class Minesweeper {
//Instance variables
    String name;
    String instructions = "Minesweeper is a logic game where\n"
            + "mines are hidden in a grid of squares.\n" 
            + "The goal of the game is to clear a board\n"
            + "containing hidden mines without detonating any of them.\n";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.getInput();
    }
}
