/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author knban_000
 */
public class MineManager implements Serializable{
    private static ArrayList<Mine> mines = new ArrayList<>();

    public MineManager() {
    }
    
    public ArrayList<Mine> getMines() {
        return mines;
    }
    
    private void sort() {
        MineCompare compare = new MineCompare();
        Collections.sort(mines, compare);
    }
    
    private void addMine (int row, char column) {
        mines.add(new Mine(row, column));
    }
    
    public void clearMines () {
        mines.clear();
    }
    
    public char getMineColumn(int index) {
        return mines.get(index).getColumn();
    }
    
    public int getMineRow(int index) {
        return mines.get(index).getRow();
    }
    
    public void generateMines(int rows, int columns, int numberOfMines) {
        clearMines();
        for (int i = 0; i < numberOfMines; i++) {
            addMine(1 + (int) (Math.random() * rows), (char) ('A' + (char) (Math.random() * columns)));
            int ri = mines.get(i).getRow();
            char ci = mines.get(i).getColumn();
            for (int j = 0; j < i; j++) {
                int rj = mines.get(j).getRow();
                char cj = mines.get(j).getColumn();
                while (ri == rj && ci == cj) {
                    mines.get(i).setRow(1 + (int) (Math.random() * rows));
                    mines.get(i).setColumn((char) ('A' + (char) (Math.random() * columns)));
                    ri = mines.get(i).getRow();
                    ci = mines.get(i).getColumn();
                }
            }
        }
        sort();
        for (Mine mine : mines) {
            System.out.println(mine.getRow() + "" + mine.getColumn());
        }
    }
    
    public void presetMines() {
        clearMines();
        addMine(9,'D');
        addMine(2,'C');
        addMine(7,'H');
        addMine(5,'G');
        addMine(7,'E');
        addMine(4,'G');
        addMine(8,'E');
        addMine(2,'G');
        addMine(2,'A');
        addMine(3,'F');
        sort();
        for (Mine mine : mines) {
            System.out.println(mine.getRow() + "" + mine.getColumn());
        }
    }
    
    // Nested Class
    private class MineCompare implements Comparator<Mine> {
        @Override
        public int compare(Mine mine1, Mine mine2) {
            int m1r = mine1.getRow();
            int m2r = mine2.getRow();
            
            char m1c = mine1.getColumn();
            char m2c = mine2.getColumn();

            if (m1r < m2r) {
                return -1;
            } else if (m1r == m2r) {
                if (m1c < m2c) {
                    return -1;
                } else if (m1c == m2c) {
                    System.out.println("Duplicate Mine");
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}
