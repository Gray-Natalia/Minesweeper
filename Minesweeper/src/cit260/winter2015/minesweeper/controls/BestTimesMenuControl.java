/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.controls;

import java.io.Serializable;
import cit260.winter2015.minesweeper.BestTimeManagerBeginner;
import cit260.winter2015.minesweeper.BestTimeManagerExpert;
import cit260.winter2015.minesweeper.BestTimeManagerIntermediate;

/**
 *
 * @author 
 */
public class BestTimesMenuControl implements Serializable {
    private static final long serialVersionUID = 1L;
     
    public static void beginnerBestTimes() {
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        System.out.println(btmb.getBestTimesString());
    }

    public static void intermediateBestTimes() {
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        System.out.println(btmi.getBestTimesString());
    }
    
    public static void expertBestTimes() {
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        System.out.println(btme.getBestTimesString());
    }
    
    public static void allBestTimes() {
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        System.out.println(btmb.getBestTimesString());
        
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        System.out.println(btmi.getBestTimesString());
        
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        System.out.println(btme.getBestTimesString());
    }
    
}
