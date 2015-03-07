/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class BestTimesMenuControl implements Serializable {
     
    public static void beginnerBestTimes() {
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        System.out.println(btmb.getBestTimesBeginnerString());
    }

    public static void intermediateBestTimes() {
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        System.out.println(btmi.getBestTimesIntermediateString());
    }
    
    public static void expertBestTimes() {
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        System.out.println(btme.getBestTimesExpertString());
    }
    
    public static void allBestTimes() {
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        System.out.println(btmb.getBestTimesBeginnerString());
        
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        System.out.println(btmi.getBestTimesIntermediateString());
        
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        System.out.println(btme.getBestTimesExpertString());
    }
    
}
