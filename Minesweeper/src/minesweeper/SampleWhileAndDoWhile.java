/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author Keith
 */
public class SampleWhileAndDoWhile {
    
       
    public static void main(String args[]) {
        
    Scanner input = new Scanner (System.in);
     
    int x = 5;
    int y = 5;
        while (x == 5) {
            System.out.println("Enter a number");
            
            int input1 = input.nextInt();
            
            if (input1 > x) {
                System.out.println("Too high.");
            }
            else if (input1 < x) {
                System.out.println("Too low.");
            }
            else if (input1 == x) {
                System.out.println("Perfect!!!");
                x = 10;
            }
        }
        do {
            //Gets user input sets = input1
            System.out.println("Enter a number (Do while)");
            
            int input2 = input.nextInt();
            
            if (input2 > y) {
                System.out.println("Too high.");
            }
            else if (input2 < y) {
                System.out.println("Too low.");
            }
            else if (input2 == y) {
                System.out.println("Perfect!!!");
                y = 10;
            }
        } while (y == 5);
    }
}
