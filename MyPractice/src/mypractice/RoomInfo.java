/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypractice;

import java.util.Scanner;

/**
 *
 * @author kalav_000
 */
public class RoomInfo {
    
    public static void main(String args[]){
         
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.getInput();
    }
    
    public void getInput(){
        System.out.println("This program will allow you to see if a room is vacant.");
    
        String selectedRoom = null;
                   
        Scanner in = new Scanner(System.in);
     
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
        // prompt for input
        System.out.println("Enter any room from A to E.");

        // get input from user           
        selectedRoom = in.nextLine();

        // no marker entered?
        if (selectedRoom == null  || selectedRoom.length() < 1) {
            System.out.println("Invalid input. Please try again.\n");
            continue;
        }
                    
        // grab only the first character and convert it to upper case
        selectedRoom = selectedRoom.substring(0, 1).toUpperCase();
        
        char c = selectedRoom.charAt(0);    
                
        // Repeats loop if input is less than A
        if (c < 'A') {  
            System.out.println("Invalid input. \nPlease try again.\n");
            continue;
        }

        // Repeats loop if input is greater than the last column
        if (c > 'E'){ 
            System.out.println("Invalid input. \nPlease try again.\n");
            continue;   
        }

        valid = true; // signal that a valid marker was entered
        }
        
    char nums[] = {'A','B','C','D','E'};
    boolean roomOcupation[] = {true,false,true,false,true};
    
    char c = selectedRoom.charAt(0);
    
    for (int i=1; i < 5; i++){
        if (nums[i] == c){
            if (roomOcupation[i]){
            System.out.println("The room " + nums[i] + " is vacant.");
        } else {
            System.out.println("Sorry, the room " + nums[i] + " is occupied.");
            }
        }
       
    }
    }
}
    
