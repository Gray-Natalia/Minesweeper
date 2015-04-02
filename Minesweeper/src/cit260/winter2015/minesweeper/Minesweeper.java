/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

import cit260.winter2015.minesweeper.menuViews.MainMenuView;
import cit260.winter2015.minesweeper.swing.MainFrame;
import javax.lang.model.type.ErrorType;

/**
 *
 * @author kalavic
 */
public class Minesweeper {

    public static MainFrame mainFrame;
    
    public static void main(String[] args) {
        try {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Minesweeper.mainFrame = new MainFrame();

                    Minesweeper.mainFrame.setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Game crashed: " + e.getMessage());
        } finally {
            if (mainFrame != null) {
                mainFrame.dispose();
            }
        }
    }
}
