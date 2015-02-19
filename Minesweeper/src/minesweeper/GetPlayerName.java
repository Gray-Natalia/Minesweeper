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
public class GetPlayerName {
    
    String greeting;
    public String playerName;
    String ifnot;
    
    public String getName() {
        GetPlayerName getPlayerName = new GetPlayerName();
        getPlayerName.greeting = "Welcome to Minesweeper.";
        getPlayerName.playerName = "Please enter your name.";
        getPlayerName.ifnot = "\nPlayer name must contain 3 to 15 characters."
                + " Please try Again.";
       
        Scanner input = new Scanner (System.in);
        System.out.println(getPlayerName.playerName);
        playerName = input.nextLine();
    
        //Checks for minumum of 3 characters and max of 15.
        //Loops if incorrect input.
        while((playerName.length() < 3) || (playerName.length() > 15)) { 
            System.out.println(getPlayerName.ifnot);
            System.out.println("");
            System.out.println(getPlayerName.playerName);
            playerName = input.nextLine();
        }
        System.out.println("Great " + playerName +", Go ahead!!!");
        return playerName;
    }  
}
    
