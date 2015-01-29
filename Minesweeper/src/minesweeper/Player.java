/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author cheryl
 * setup CLASS
 */
public class Player {
 /***
  * setup two instances for class PLAYER
  */   
String firstName;
String lastName;
String playerWelcome = "Please enter your first and last name. We hope you enjoy playing our version of Minesweeper";
/****
 * setup two functions so players can input their first and last names to play the game
 */
public void getFirstName() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your first name: ");
    this.firstName = input.next();  
}
public void getLastName(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your last name: ");
    this.lastName = input.next();
}
}
