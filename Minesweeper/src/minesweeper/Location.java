/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Alfonso
 */
public class Location {
    int columnTotal;  //Number of columns
    int rowTotal; //Number of rows
    int squeres = columnTotal + rowTotal;
    int numMines = (columnTotal*rowTotal)- squeres;
    
    boolean mines;
    
    
    public Location (){
    
  
    double random = Math.random (); //To define randomly if it exist or not a mine
            if (random>0.9)   //10% of probability to exist a mine
                mines=true;
            else
                mines=false;
           
           
    }      
}

