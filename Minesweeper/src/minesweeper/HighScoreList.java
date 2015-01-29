/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
/**
 *
 * @author cheryl
 */
public class HighScoreList {
    public void DisplayhHighScoreList(){ 
         System.out.println("High Score List" + "\n");
            for (int i = 0; i <10; i++) {
                System.out.println(ranking[i] + "." + "\t" +  playerName[i] + 
                        "\t" + ((int) time[i]/60) + ":" + ((int) time[i]%60));
            }
    }    
}
