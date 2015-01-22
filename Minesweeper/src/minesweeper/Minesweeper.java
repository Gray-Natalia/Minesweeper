/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author kalavic
 */
public class Minesweeper {
//Instance variables
    String name;
    String welcomeText = "Hello, this is the Minesweeper game.\n"
            + " Press the button to proceed with the game.";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Minesweeper myGame = new Minesweeper();
        myGame.getName();
        myGame.displayWelcome();
        // TODO code application logic here
    }

    /**
     *
     */
    public void getName(){
        // Getting the name of the player
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name = input.next();
    }

    /**
     *
     */
    public void displayWelcome() {
        //Displaying wencome message
        System.out.println("\nWelcome" + this.name + "\n");
        System.out.println(this.welcomeText);
    }
}