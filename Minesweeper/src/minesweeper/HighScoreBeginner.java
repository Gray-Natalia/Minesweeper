/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Keith
 */
public class HighScoreBeginner {
    public static void main(String[] args) {
        int[] ranking = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        String[] playerName = {"John", "James", "Jill", "Bill", 
        "Kevin", "Nate", "Bob", "Dan", "Amy", "Jane" };
        double[] time = { 10.5, 20.23, 30, 35, 40, 55, 65, 85, 93, 100 };
        
       
        System.out.println(ranking[0] + "." + "\t" + playerName[0] + "\t" + time[0]);
    }
}
