/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.Winter2014.Minesweeper.Views;

/**
 *
 * @author cheryl
 */
public interface ViewInterface {
   public void executeCommands(); 
   public void display(String menuName);
   public String getCommand();
}
