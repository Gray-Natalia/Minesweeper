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
    String instructions = "Minesweeper is a logic game where\n"
            + "mines are hidden in a grid of squares.\n" 
            + "The goal of the game is to clear a board\n"
            + "containing hidden mines without detonating any of them.\n";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Minesweeper myGame = new Minesweeper();
        myGame.getName();
        myGame.displayHelp();
        
    Game beginner = new Game("Beginner", 9, 2);
    beginner.describeLevel();
    Game intermediate = new Game("Intermediate", 81, 13);
    intermediate.describeLevel();
    Game expert = new Game("Expert", 256, 40);
    expert.describeLevel();
       }

    /**
     *First function
     */
    public void getName(){
        // Getting the name of the player
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name = input.next();
    }

    /**
     *HEre is the second function
     */
    public void displayHelp() {
        //Displaying wencome message
        System.out.println("\nWelcome " + this.name + "\n");
        System.out.println(this.instructions);
    }
}
