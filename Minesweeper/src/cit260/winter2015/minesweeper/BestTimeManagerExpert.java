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
public class BestTimeManagerExpert extends BestTimeManager {

    private static final String BEST_TIMES_EXPERT_FILE = "resources/best_times_expert.dat";

    public BestTimeManagerExpert() {
        super(BEST_TIMES_EXPERT_FILE, "Expert");
    }
    
    public static String getBestTimesString() {
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        return btme.setBestTimesString();
    }
}
