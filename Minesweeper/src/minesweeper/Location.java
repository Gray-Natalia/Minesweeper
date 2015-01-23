/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import javax.swing.JButton;  // Here location obtains the properties of a button

/**
 *
 * @author Alfonso
 */
public class Location extends JButton{  // Location becomes a button
                
        private boolean mine;     //Location will have a mine (true of false)
        
      
        public Location() {   //Constructor
            
            super();  
            double random = Math.random (); //To define randomly if it exist or not a mine
            if (random>0.9)   //10% of probability to exist a mine
                mine=true;
            else
                mine=false;
            
        }
        
      public boolean isMined(){
          return mine;
      }  
}
