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
 */
public class Lesson_3_individual_program_CRubenstein {
  /***
   * Lesson 3 individual assignment - two primitive variables, two math operators, /n
   * one relational or logical operator, type casting and two character escape sequences
   */
    String playerName;
    String welcome = "Please enter a player name to begin game";
    public void getPlayerName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your player name: ");
        playerName = input.next();
    }
     public void DisplayLevelInfo(){ 
         System.out.println("Please choose level: Beginner, Intermediate or Advanced level");
     }
    String level = "Beginner, Intermediate, Advanced";
           public void getLevel(){
             Scanner input = new Scanner(System.in);
        System.out.println("Enter your level: ");
        level = input.next();
        }
           double answer;
        public void getAnswer(){
            Scanner input = new Scanner(System.in);
          System.out.println("Enter your answer here: ");
          answer = input.nextDouble();
        }
            public void DisplayQuestion(){
                System.out.println("8 x 2 = ");
            }
          
        public void checkAnswer(){
            if(answer == 16){
 System.out.println ("Correct Answer! Great Job!!");
}
               else {
                System.out.println ("Sorry, incorret answer. Try again?");
                String response = "yes, no";
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter yes or no: ");
                    response = input.next();
                     if (response == "yes"){
                    System.out.println("8 x 2 = ");
                    getAnswer();
else System.out.println("The answer was 16. Next problem?");
     string response = "yes, no"
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter yes or no: ")
                   if answer = yes;
/* go back top need new problem
*/
else System.out.println ("Game over");  
}
else
/* go back to top need new problem
}
*/
}
