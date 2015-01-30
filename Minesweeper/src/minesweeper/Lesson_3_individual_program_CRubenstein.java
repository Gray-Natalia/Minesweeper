
/***
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 ***/
package minesweeper;

import java.util.Scanner;

/***
 * @author cheryl
 ***/
public class Lesson_3_individual_program_CRubenstein {
        /***
         * Lesson 3 individual assignment - two primitive variables, two math operators, /n
         * one relational or logical operator, type casting and two character escape sequences
         ***/
    String playerName;
    String welcome;
        String level;
        int num1;
        int num2;
        double answer;

        Lesson_3_individual_program_CRubenstein() {
                String welcome = "Please enter a player name to begin game";
                String level = "Beginner";
                num1 = (int)(Math.random()*10);
                num2 = (int)(Math.random()*10);
        }

    public void getPlayerName(){
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your player name: ");
                playerName = input.next();
    }

    public void DisplayLevelInfo(){
         System.out.println("Please choose level: Beginner, Intermediate or Advanced level");
    }

    public void getLevel(){
                Scanner input = new Scanner(System.in);
        System.out.print("Enter your level: ");
        level = input.next();
    }

    public void getAnswer(){
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your answer here: ");
                answer = input.nextDouble();
    }

        public void displayQuestion(){
                System.out.println(num1 + " x " + num2 + " = ");
        }

        public void checkAnswer() {
                if(answer == num1 * num2) {
                        System.out.println("Correct Answer! Great Job!!\n");
                }
                else {
                        System.out.println("Sorry, incorrect answer.\n The answer was \"" + num1 * num2 + "\"");
                }
        }

       /* public static void main(String args[]) {
                Lesson_3_individual_program_CRubenstein ob1 = new Lesson_3_individual_program_CRubenstein();
                ob1.displayQuestion();
                ob1.getAnswer();
                ob1.checkAnswer();

                Lesson_3_individual_program_CRubenstein ob2 = new Lesson_3_individual_program_CRubenstein();
                ob2.displayQuestion();
                ob2.getAnswer();
                ob2.checkAnswer();
        }*/
}
