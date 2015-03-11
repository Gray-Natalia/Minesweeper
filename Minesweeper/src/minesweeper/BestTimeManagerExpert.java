/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;



/**
 *
 * @author Keith Banner
 */
public class BestTimeManagerExpert extends BestTimeManager {

    private static final String BEST_TIMES_EXPERT_FILE = "best_times_expert.dat";

    public BestTimeManagerExpert() {
        super(BEST_TIMES_EXPERT_FILE);
    }
    

    @Override
    public String getBestTimesString() {
        loadBestTimesFile();
        
        StringBuilder bestTimesString  = new StringBuilder(""
                + "\n\t==============================================================="
                + "\n\tExpert Best Times"
                + "\n\t==============================================================="
                + "\n\t   Rank\t\tName\t\tTime"
                + "\n\t---------------------------------------------------------------"
                + "\n");
        
        int i = 0;
        int x = bestTimes.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            bestTimesString.append("\t   ")
                    .append(i + 1)
                    .append(".\t\t")
                    .append(bestTimes.get(i).getPlayerName())
                    .append("\t\t")
                    .append(convertTime(bestTimes.get(i).getTime()))
                    .append("\n");
            i++;
        }
        
        bestTimesString.append("\tThe average best time is ")
                .append(calculateAverageTime());
        
        return bestTimesString.toString();
    }
    

}
