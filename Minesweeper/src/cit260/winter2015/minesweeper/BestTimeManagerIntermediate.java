/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;


/**
 *
 * @author Keith Banner
 */
public class BestTimeManagerIntermediate extends BestTimeManager {

    private static final String BEST_TIMES_INTERMEDIATE_FILE = "best_times_intermediate.dat";
    

    public BestTimeManagerIntermediate() {
       super(BEST_TIMES_INTERMEDIATE_FILE, "Intermediate");
    }
    
    public static String getBestTimesString() {
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        return btmi.setBestTimesString();
    }
}  

