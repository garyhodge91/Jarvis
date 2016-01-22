package com.example.jarvis;

import java.util.ArrayList;

public class CarryOutCommand {
	
	public void findCommands(String command){
		int actionDefId = 0;
		ArrayList actionDefIds;
		// Search database to see if the string matches a command
		
		/*Search DB*/
		
//		loop through action def ids and execute the action
		executeAction(actionDefId);
//		if no commands are found perform a google search
		webSearch(command);
		
	}
	
	private void executeAction(int actionDefId){
		
	}
	
	private void webSearch(String query){
		
	}

}
