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

import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BestTimes implements Serializable
{
    BestTimes[] beginner = new BestTimes[10];
    BestTimes[] intermediate = new BestTimes[10];
    BestTimes[] expert = new BestTimes[10];

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        BestTimes bestTimes = new BestTimes();
        bestTimes.outputToFile();
        bestTimes.inputFromFile();
    }
        public BestTimes() {
        beginner[0] = new BestTimes(1, "John", 10.5);
        beginner[1] = new BestTimes(2, "James", 20.3);
        beginner[2] = new BestTimes(3, "Jill", 30);
        beginner[3] = new BestTimes(4, "Bill", 35);
        beginner[4] = new BestTimes(5, "Kevin", 40);
        beginner[5] = new BestTimes(6, "Nate", 55);
        beginner[6] = new BestTimes(7, "Bob", 75);
        beginner[7] = new BestTimes(8, "Dan", 85);
        beginner[8] = new BestTimes(9, "Amy", 93);
        beginner[9] = new BestTimes(10, "Jane", 100);

        intermediate[0] = new BestTimes(1, "John", 110.5);
        intermediate[1] = new BestTimes(2, "James", 120.3);
        intermediate[2] = new BestTimes(3, "Jill", 130);
        intermediate[3] = new BestTimes(4, "Bill", 135);
        intermediate[4] = new BestTimes(5, "Kevin", 140);
        intermediate[5] = new BestTimes(6, "Nate", 155);
        intermediate[6] = new BestTimes(7, "Bob", 175);
        intermediate[7] = new BestTimes(8, "Dan", 185);
        intermediate[8] = new BestTimes(9, "Amy", 193);
        intermediate[9] = new BestTimes(10, "Jane", 200);

        expert[0] = new BestTimes(1, "John", 210.5);
        expert[1] = new BestTimes(2, "James", 220.3);
        expert[2] = new BestTimes(3, "Jill", 230);
        expert[3] = new BestTimes(4, "Bill", 235);
        expert[4] = new BestTimes(5, "Kevin", 240);
        expert[5] = new BestTimes(6, "Nate", 255);
        expert[6] = new BestTimes(7, "Bob", 275);
        expert[7] = new BestTimes(8, "Dan", 285);
        expert[8] = new BestTimes(9, "Amy", 293);
        expert[9] = new BestTimes(10, "Jane", 300);
        }

    public int ranking;
    public String playerName;
    public double time;

    public BestTimes(int r, String p, double t) 
    {
        ranking = r;
        playerName = p;
        time = t;
    }

    public void outputToFile() throws IOException {
        try(FileOutputStream f = new FileOutputStream("bestTimes.txt"); ObjectOutputStream s = new ObjectOutputStream(f)) {
            s.writeObject(beginner);
            s.writeObject(intermediate);
            s.writeObject(expert);
            s.flush();
        }

    }
    
    public void inputFromFile() throws IOException, ClassNotFoundException {
        BestTimes[] beginner2, intermediate2, expert2;
        try(FileInputStream in = new FileInputStream("bestTimes.txt"); ObjectInputStream s = new ObjectInputStream(in)) {
            beginner2 = (BestTimes[]) s.readObject();
            intermediate2 = (BestTimes[]) s.readObject();
            expert2 = (BestTimes[]) s.readObject();
        }
        System.out.println(beginner2[1].playerName);
    }
}

