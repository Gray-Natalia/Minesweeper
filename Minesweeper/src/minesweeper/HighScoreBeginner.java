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
        
        System.out.println(ranking[3] + "." + "\t" + playerName[3] + "\t" + time[3]);
        
        playerName[3] = "Jessica";
       
        System.out.println(ranking[3] + "." + "\t" + playerName[3] + "\t" + time[3]);
    }
    public static void returnArray(int[] ranking) {
        for (int i = 0; i < ranking.length; i++) {
            System.out.print(ranking[i] + " ");
        }
    }
}

