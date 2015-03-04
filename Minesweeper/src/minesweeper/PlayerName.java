/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

/**
 *
 * @author Alfonso
 */
public class PlayerName {
    
    public static void main (String args[]){
        
        List<String> playerNames = new ArrayList<>();
        
                playerNames.add("John");
		playerNames.add("Melissa");
		playerNames.add("Andrew");
		playerNames.add("Laura");
		playerNames.add("Robert");
		playerNames.add("Sandra");
		playerNames.add("Dan");
		playerNames.add("Katherine");
		playerNames.add("William");
        
     	
		Collections.sort(playerNames);
 

		System.out.println("Players List");
		for(String temp: playerNames){
			System.out.println(temp);
    }
        
    }
    
}
