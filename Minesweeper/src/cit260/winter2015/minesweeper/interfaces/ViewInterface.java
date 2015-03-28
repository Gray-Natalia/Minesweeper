/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.interfaces;

import cit260.winter2015.minesweeper.exceptions.EndGameException;

/**
 *
 * @author cheryl
 */
public interface ViewInterface {
   public void executeCommands() throws EndGameException; 
}
