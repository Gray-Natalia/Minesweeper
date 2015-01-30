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

import java.util.Arrays;

public class HighScores 
{
    public static void main(String[] args){
    
    }
    
    HighScores[] beginner = new HighScores[10];
    HighScores[] intermediate = new HighScores[10];
    HighScores[] expert = new HighScores[10];
    
        public HighScores() {
        beginner[0] = new HighScores(1, "John", 10.5);
        beginner[1] = new HighScores(2, "James", 20.3);
        beginner[2] = new HighScores(3, "Jill", 30);
        beginner[3] = new HighScores(4, "Bill", 35);
        beginner[4] = new HighScores(5, "Kevin", 40);
        beginner[5] = new HighScores(6, "Nate", 55);
        beginner[6] = new HighScores(7, "Bob", 75);
        beginner[7] = new HighScores(8, "Dan", 85);
        beginner[8] = new HighScores(9, "Amy", 93);
        beginner[9] = new HighScores(10, "Jane", 100);
        
        intermediate[0] = new HighScores(1, "John", 110.5);
        intermediate[1] = new HighScores(2, "James", 120.3);
        intermediate[2] = new HighScores(3, "Jill", 130);
        intermediate[3] = new HighScores(4, "Bill", 135);
        intermediate[4] = new HighScores(5, "Kevin", 140);
        intermediate[5] = new HighScores(6, "Nate", 155);
        intermediate[6] = new HighScores(7, "Bob", 175);
        intermediate[7] = new HighScores(8, "Dan", 185);
        intermediate[8] = new HighScores(9, "Amy", 193);
        intermediate[9] = new HighScores(10, "Jane", 200);
        
        expert[0] = new HighScores(1, "John", 210.5);
        expert[1] = new HighScores(2, "James", 220.3);
        expert[2] = new HighScores(3, "Jill", 230);
        expert[3] = new HighScores(4, "Bill", 235);
        expert[4] = new HighScores(5, "Kevin", 240);
        expert[5] = new HighScores(6, "Nate", 255);
        expert[6] = new HighScores(7, "Bob", 275);
        expert[7] = new HighScores(8, "Dan", 285);
        expert[8] = new HighScores(9, "Amy", 293);
        expert[9] = new HighScores(10, "Jane", 300);
        }
        
    public int ranking;
    public String playerName;
    public double time;
    
    public HighScores(int r, String p, double t) 
    {
        ranking = r;
        playerName = p;
        time = t;
    }
}

