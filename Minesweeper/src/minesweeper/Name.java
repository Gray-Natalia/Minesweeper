/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author DilexsaTech
 */
public class Name {
    
    String greeting;
    public String playerName;
    String ifnot;
    
    public static void main(String[] args) {
        Name Name = new Name();
        Name.getName();     
    
    } 
    /** Moved from main to getName by Keith to own method for greater 
     * accessibility from other classes. 
     * @return 
     */
    public String getName() {  
        Name intro = new Name();
        intro.greeting = "Welcome to Minesweeper.";
        intro.playerName = "Please enter your name.";
        intro.ifnot = "\nPlayer name must contain 3 to 15 characters."
                + " Please try Again.";
       
        Scanner input = new Scanner (System.in);
        System.out.println(intro.playerName);
        playerName = input.nextLine();
    
        //Checks for minumum of 3 characters and max of 15.
        //Loops if incorrect input.
        while((playerName.length() < 3) || (playerName.length() > 15)) { 
            System.out.println(intro.ifnot);
            System.out.println("");
            System.out.println(intro.playerName);
            playerName = input.nextLine();
        }
        System.out.println("Great " + playerName +", Go ahead!!!");
        return playerName;
    }  
}
    
