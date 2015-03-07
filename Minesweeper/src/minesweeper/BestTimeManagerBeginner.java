/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author knban_000
 */
public class BestTimeManagerBeginner {
    // ArrayList type is bestTimesBeginner (Uses BestTimeBeginner constructor)
    private ArrayList<BestTime> bestTimesBeginner;
    
    // Number of values held in the best times list.
    int max = 10;
    
    // The name of the file where the best times will be saved.
    private static final String BEST_TIMES_BEGINNER_FILE = "best_times_beginner.dat";
    
    //Initializes the input and output streams
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public BestTimeManagerBeginner() {
        bestTimesBeginner = new ArrayList<>();
    }
    
    public ArrayList<BestTime> getBestTimesBeginner() {
        loadBestTimesBeginnerFile();
        sort();
        return bestTimesBeginner;
    }
    
    private void sort() {
        BestTimeCompare compare = new BestTimeCompare();
        Collections.sort(bestTimesBeginner, compare);
    }
    
    public void addBestTime(String name, double time) {
        loadBestTimesBeginnerFile();
        if(bestTimesBeginner.size() >= 10 && time >= bestTimesBeginner.get(9).getTime()) {
            System.out.println("Sorry you did not make the top ten best times."
                    + "Better luck next time.");
        }
        else {
            if(bestTimesBeginner.size() >= 10) {
                for(int i = 9; i < bestTimesBeginner.size(); i++) {
                    bestTimesBeginner.remove(bestTimesBeginner.get(i));
                }
            }
            bestTimesBeginner.add(new BestTime(name, time));
            sort();
            updateBestTimesBeginnerFile();
        }
    }
    
    public void loadBestTimesBeginnerFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(BEST_TIMES_BEGINNER_FILE));
            // This cast is unchecked and throws an error.
            bestTimesBeginner = (ArrayList<BestTime>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            clearBestTimesBeginnerFile();
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
    
    public void updateBestTimesBeginnerFile() {
        if(bestTimesBeginner.size() > 10) {
            for(int i = 10; i < bestTimesBeginner.size(); i++) {
                bestTimesBeginner.remove(bestTimesBeginner.get(i));
            }
        }
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(BEST_TIMES_BEGINNER_FILE));
            outputStream.writeObject(bestTimesBeginner);
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
    
    public void clearBestTimesBeginnerFile() {
        bestTimesBeginner.clear();
        try {
            PrintWriter writer = new PrintWriter(BEST_TIMES_BEGINNER_FILE);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Best Times file not found: " + e.getMessage()
                    + "\nThe program will try to make a new file");
        }
    }
    
    public String getBestTimesBeginnerString() {
        loadBestTimesBeginnerFile();
        
        StringBuilder bestTimesBeginnerString  = new StringBuilder(""
                + "\n\t==============================================================="
                + "\n\tBeginner Best Times"
                + "\n\t==============================================================="
                + "\n\t   Rank\t\tName\t\tTime"
                + "\n\t---------------------------------------------------------------"
                + "\n");
        
        int i = 0;
        int x = bestTimesBeginner.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            bestTimesBeginnerString.append("\t   ")
                    .append(i + 1)
                    .append(".\t\t")
                    .append(bestTimesBeginner.get(i).getPlayerName())
                    .append("\t\t")
                    .append(convertTime(bestTimesBeginner.get(i).getTime()))
                    .append("\n");
            i++;
        }
        
        bestTimesBeginnerString.append("\tThe average beginner best time is ")
                .append(calculateAverageTime());
        
        return bestTimesBeginnerString.toString();
    }
    
    private String convertTime(double time) {
        String output;
            output = (((int) time/60) + ":" + String.format("%02d",(int) time%60));
        return output;
    }
    
    private String calculateAverageTime() {
        double total = 0;
        for (BestTime bestTimesBeginner1 : bestTimesBeginner) {
            total += bestTimesBeginner1.getTime();
        }
        double average = total / bestTimesBeginner.size();
        
        String output;
        if (average < 60) {
            output = (String.format("%.2f", average) + " seconds.");
        }
        else {
            output = (((int) average/60) + ":" + String.format("%02d",(int) average%60) + ".");
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
}
