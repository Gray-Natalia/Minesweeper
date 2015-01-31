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
public class NatGray {
    
public static void main(String[] args) {
        NatGra();     
    
    }     
   public static void NatGra()
   {
      int weight = 0, height = 0;
      double bmi;
      
      System.out.println("This is the Body Mass Index calculator");
      
      Scanner input = new Scanner (System.in);
 
      System.out.println("Enter your weight in kg without gramms");
       if(input.hasNextInt()) { //возвращает истинну если с потока ввода можно считать целое число
       weight = input.nextInt();
       } else {
          System.out.println("The number you enters wasn't in integer");
        }
        
      Scanner input1 = new Scanner (System.in); 
      
      System.out.println("Enter your height in cm");
      if(input1.hasNextInt()) { //возвращает истинну если с потока ввода можно считать целое число
       height = input1.nextInt();
       } else {
          System.out.println("The number you enters wasn't in integer");
        }
       
      
       bmi = weight/((double)(height*height)/100);
    
      
       if(bmi < 18.5) {
       System.out.println("Your Body Mass Index is " + bmi + ".\n" + "You are \'underweight\'.");
        } else if (bmi < 24.9){
            System.out.println("Your Body Mass Index is " + bmi + ".\n" + "You are \'normal\'.");
        } else if (bmi < 29.9){
        System.out.println("Your Body Mass Index is " + bmi + ".\n" + "You are \'overweight\'.");
        } else if (bmi >= 30){
            System.out.println("Your Body Mass Index is " + bmi + ".\n" + "You suffer from \'Obesity\'.");
        } 
       }}

