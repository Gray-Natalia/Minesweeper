/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

import cit260.winter2015.minesweeper.swing.MainFrame;



/**
 *
 * @author kalavic
 */
public class Minesweeper {

    public static MainFrame mainFrame;
    public static MineManager mm = new MineManager();
    public static CellManager cm = new CellManager();
    public static GameVariables gameVariables = new GameVariables();
    
    public static void main(String[] args) {
        try {

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Minesweeper.mainFrame = new MainFrame();
                    Minesweeper.mainFrame.setVisible(true);
                }
            });
        } catch (Exception e) {
            System.err.println("Game crashed: " + e.getMessage());
        } finally {
            if (mainFrame != null) {
                mainFrame.dispose();
            }
        }
    }
}
