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
     
        
  public static void main (String[] args, String B, String I, String E) {
   
            
    String greeting = "Enter the level to play B (Beginner), I (Intermediate) or E (Expert).";
    String warning = "Only B (Beginner), I (Intermediate) or E (Expert) is allowed.";
    String message = "You have entered (level difficulty) with (number) columns and (number) rows.";
    
    
  }
    int columnBeginner = 3;
    int columnIntermediate = 9;
    int columnExpert = 16;
    int rowBeginner = 3;
    int rowIntermediate = 9;
    int rowExpert = 16;
    
    Location level = new Location();
    
   
            
    int squaresBeginner = columnBeginner *  rowBeginner;
    int squareIntermediate = columnIntermediate * rowIntermediate;
    int squareExpert = columnExpert * columnExpert;
    
    boolean mines;
     
         
    
    public Location (){
        
                        
      double Beginner = 'x';
        if (Beginner>0.9)
            mines = true;
        else
            mines=false;
             
       
      double Intermediate = 'x';
            if(Intermediate >0.7)
                mines = true;
            else
                mines=false;
      
      
      double Expert = 'x';
            if(Expert >0.5)    
                mines = true;
            else
                mines=false;
                         
    }
    
    public boolean isMined(){
        return false;
        }    
   
}

