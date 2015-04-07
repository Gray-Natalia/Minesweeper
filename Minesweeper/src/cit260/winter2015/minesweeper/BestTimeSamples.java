/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

import java.io.Serializable;
/**
 *
 * @author Keith Banner
 */
public class BestTimeSamples implements Serializable{
    private static final long serialVersionUID = 1L;
    public static void main(String args[]) {
        
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        
        btmb.clearBestTimesFile();
        btmi.clearBestTimesFile();
        btme.clearBestTimesFile();
        
        // Beginner
        btmb.addBestTime("John", 10.5);
        btmb.addBestTime("James", 20.3);
        btmb.addBestTime("Jill", 30);
        btmb.addBestTime("Bill", 35);
        btmb.addBestTime("Kevin", 40);
        btmb.addBestTime("Nate", 55);
        btmb.addBestTime("Bob", 75);
        btmb.addBestTime("Dan", 85);
        btmb.addBestTime("Amy", 93);
        btmb.addBestTime("Jane", 100);
        
        
        
        // Intermediate
        btmi.addBestTime("John", 110.5);
        btmi.addBestTime("James", 120.3);
        btmi.addBestTime("Jill", 130);
        btmi.addBestTime("Bill", 135);
        btmi.addBestTime("Kevin", 140);
        btmi.addBestTime("Nate", 155);
        btmi.addBestTime("Bob", 175);
        btmi.addBestTime("Dan", 185);
        btmi.addBestTime("Amy", 193);
        btmi.addBestTime("Jane", 200);
        
        // Expert
        btme.addBestTime("John", 210.5);
        btme.addBestTime("James", 220.3);
        btme.addBestTime("Jill", 230);
        btme.addBestTime("Bill", 235);
        btme.addBestTime("Kevin", 240);
        btme.addBestTime("Nate", 255);
        btme.addBestTime("Bob", 275);
        btme.addBestTime("Dan", 285);
        btme.addBestTime("Amy", 293);
        btme.addBestTime("Jane", 300);
        
        System.out.println(btmb.setBestTimesString());
        System.out.println(btmi.setBestTimesString());
        System.out.println(btme.setBestTimesString());
    }
}
