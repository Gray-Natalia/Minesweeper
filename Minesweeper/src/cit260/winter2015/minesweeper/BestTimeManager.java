/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author cheryl
 */
public abstract class BestTimeManager {

    // ArrayList type is bestTimesBeginner (Uses BestTimeBeginner constructor)

    protected ArrayList<BestTime> bestTimes;
    protected final String BEST_TIMES_FILE;
    protected final String levelName;
    // Number of values held in the best times list.
    int max = 10;
    //Initializes the input and output streams
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public BestTimeManager() {
        bestTimes = new ArrayList<>();
        BEST_TIMES_FILE = "best_times.dat";
        levelName = "Level";
    }

    public BestTimeManager(String file, String level) {
        bestTimes = new ArrayList<>();
        BEST_TIMES_FILE = file;
        levelName = level;
    }

    public ArrayList<BestTime> getBestTimes() {
        loadBestTimesFile();
        sort();
        return bestTimes;
    }

    private void sort() {
        BestTimeManager.BestTimeCompare compare = new BestTimeManager.BestTimeCompare();
        Collections.sort(bestTimes, compare);
    }

    public void addBestTime(String name, double time) {
        loadBestTimesFile();
        if (bestTimes.size() >= 10 && time >= bestTimes.get(9).getTime()) {
            System.out.println("Sorry you did not make the top ten best times."
                    + "Better luck next time.");
        } else {
            if (bestTimes.size() >= 10) {
                for (int i = 9; i < bestTimes.size(); i++) {
                    bestTimes.remove(bestTimes.get(i));
                }
            }
            bestTimes.add(new BestTime(name, time));
            sort();
            updateBestTimesFile();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadBestTimesFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(BEST_TIMES_FILE));
            // This cast is unchecked and throws an error.
            bestTimes = (ArrayList<BestTime>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            clearBestTimesFile();
        } catch (IOException e) {
            if (inputStream != null) {
                System.out.println("IO Error: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }
    }

    public void updateBestTimesFile() {
        if (bestTimes.size() > 10) {
            for (int i = 10; i < bestTimes.size(); i++) {
                bestTimes.remove(bestTimes.get(i));
            }
        }
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(BEST_TIMES_FILE));
            outputStream.writeObject(bestTimes);
        } catch (FileNotFoundException e) {
            System.out.println("Best Times file not found: " + e.getMessage()
                    + "\nThe program will try to make a new file");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }
    }

    public void clearBestTimesFile() {
        bestTimes.clear();
        try {
            PrintWriter writer = new PrintWriter(BEST_TIMES_FILE);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Best Times file not found: " + e.getMessage()
                    + "\nThe program will try to make a new file");
        }
    }

    protected String convertTime(double time) {
        String output;
        output = (((int) time / 60) + ":" + String.format("%02d", (int) time % 60));
        return output;
    }

    protected String calculateAverageTime() {
        double total = 0;
        for (BestTime bestTimes1 : bestTimes) {
            total += bestTimes1.getTime();
        }
        double average = total / bestTimes.size();

        String output;
        if (average < 60) {
            output = (String.format("%.2f", average) + " seconds.");
        } else {
            output = (((int) average / 60) + ":" + String.format("%02d", (int) average % 60) + ".");
        }
        return output;
    }

    private class BestTimeCompare implements Comparator<BestTime> {

        @Override
        public int compare(BestTime bestTime1, BestTime bestTime2) {
            double bt1 = bestTime1.getTime();
            double bt2 = bestTime2.getTime();

            if (bt1 < bt2) {
                return -1;
            } else if (bt1 > bt2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    public String setBestTimesString() {
        
        loadBestTimesFile();
        
        StringBuilder bestTimesString  = new StringBuilder(""
                + "\n   Rank\tName\tTime"
                + "\n---------------------------------------------------------------"
                + "\n");
        
        int i = 0;
        int x = bestTimes.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            bestTimesString.append("   ")
                    .append(i + 1)
                    .append(".\t")
                    .append(bestTimes.get(i).getPlayerName())
                    .append("\t")
                    .append(convertTime(bestTimes.get(i).getTime()))
                    .append("\n");
            i++;
        }
        
        bestTimesString.append("The ")
                .append(levelName)
                .append(" average best time is ")
                .append(calculateAverageTime());
        
        return bestTimesString.toString();
    }
}
