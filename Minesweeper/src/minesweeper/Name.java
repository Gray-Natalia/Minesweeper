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
    String name;
    String ifnot;
    
    public static void main(String[] args) {
        
        Name intro = new Name();
        intro.greeting = "welcome to Minesweeper game";
        intro.name = "Please, enter your name";
        intro.ifnot =" your name must contain at least 4 character, Try Again!!";
       
        String name;
        //int four = 4;
        Scanner input = new Scanner (System.in);
        System.out.println(intro.name);
        name = input.nextLine();
        
    if ( name.length()>= 4) System.out.println("Great " + name +", Go ahead!!!");
    else System.out.println(name + intro.ifnot);
    
    } 
    
    }
    
