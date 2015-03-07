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
public class BestTimeManagerIntermediate implements Serializable {
    // ArrayList type is bestTimesIntermediate (Uses BestTimeIntermediate constructor)
    private ArrayList<BestTime> bestTimesIntermediate;
    
    // Number of values held in the best times list.
    int max = 10;
    
    // The name of the file where the best times will be saved.
    private static final String BEST_TIMES_INTERMEDIATE_FILE = "best_times_intermediate.dat";
    
    //Initializes the input and output streams
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public BestTimeManagerIntermediate() {
        bestTimesIntermediate = new ArrayList<>();
    }
    
    public ArrayList<BestTime> getBestTimesIntermediate() {
        loadBestTimesIntermediateFile();
        sort();
        return bestTimesIntermediate;
    }
    
    private void sort() {
        BestTimeCompare compare = new BestTimeCompare();
        Collections.sort(bestTimesIntermediate, compare);
    }
    
    public void addBestTime(String name, double time) {
        loadBestTimesIntermediateFile();
        if(bestTimesIntermediate.size() >= 10 && time >= bestTimesIntermediate.get(9).getTime()) {
            System.out.println("Sorry you did not make the top ten best times."
                    + "Better luck next time.");
        }
        else {
            if(bestTimesIntermediate.size() >= 10) {
                for(int i = 9; i < bestTimesIntermediate.size(); i++) {
                    bestTimesIntermediate.remove(bestTimesIntermediate.get(i));
                }
            }
            bestTimesIntermediate.add(new BestTime(name, time));
            sort();
            updateBestTimesIntermediateFile();
        }
    }
    
    public void loadBestTimesIntermediateFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(BEST_TIMES_INTERMEDIATE_FILE));
            // This cast is unchecked and throws an error.
            bestTimesIntermediate = (ArrayList<BestTime>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            clearBestTimesIntermediateFile();
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
    
    public void updateBestTimesIntermediateFile() {
        if(bestTimesIntermediate.size() > 10) {
            for(int i = 10; i < bestTimesIntermediate.size(); i++) {
                bestTimesIntermediate.remove(bestTimesIntermediate.get(i));
                System.out.println("bestTimesIntermediate number " + i + "removed.");
            }
        }
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(BEST_TIMES_INTERMEDIATE_FILE));
            outputStream.writeObject(bestTimesIntermediate);
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
    
    public void clearBestTimesIntermediateFile() {
        bestTimesIntermediate.clear();
        try {
            PrintWriter writer = new PrintWriter(BEST_TIMES_INTERMEDIATE_FILE);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Best Times file not found: " + e.getMessage()
                    + "\nThe program will try to make a new file");
        }
    }
    
    public String getBestTimesIntermediateString() {
        loadBestTimesIntermediateFile();
        
        StringBuilder bestTimesIntermediateString  = new StringBuilder(""
                + "\n\t==============================================================="
                + "\n\tIntermediate Best Times"
                + "\n\t==============================================================="
                + "\n\t   Rank\t\tName\t\tTime"
                + "\n\t---------------------------------------------------------------"
                + "\n");
        
        int i = 0;
        int x = bestTimesIntermediate.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            bestTimesIntermediateString.append("\t   ")
                    .append(i + 1)
                    .append(".\t\t")
                    .append(bestTimesIntermediate.get(i).getPlayerName())
                    .append("\t\t")
                    .append(convertTime(bestTimesIntermediate.get(i).getTime()))
                    .append("\n");
            i++;
        }
        
        bestTimesIntermediateString.append("\tThe average intermediate best time is ")
                .append(calculateAverageTime());
        
        return bestTimesIntermediateString.toString();
    }
    
    private String convertTime(double time) {
        String output;
            output = (((int) time/60) + ":" + String.format("%02d",(int) time%60));
        return output;
    }
    
    private String calculateAverageTime() {
        double total = 0;
        for (BestTime bestTimesIntermediate1 : bestTimesIntermediate) {
            total += bestTimesIntermediate1.getTime();
        }
        double average = total / bestTimesIntermediate.size();
        
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
