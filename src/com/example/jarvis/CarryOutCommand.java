package com.example.jarvis;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.util.Action;
import com.example.util.Command;

public class CarryOutCommand {

	public void findCommands(String utterance, Context context){
		SharedPreferences sp = context.getSharedPreferences("jarvisSP", 0);
		String json = sp.getString("commands", "");
		boolean found = false;
		
		if(json.length() > 0){
			try {
				JSONArray commands = new JSONArray(json);
				for(int i = 0; i < commands.length(); i++){
					Command command = (Command) commands.get(i);
					if(command.getUtterance().equals(utterance)){
						found = true;
						for(int j = 0; j < command.getActions().size(); j++){
							Action action = command.getActions().get(j);
							action.getActionDef().execute(action.getParam1(), action.getParam2(), action.getParam3(), context);
						}
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!found){
			webSearch(utterance);
		}

	}


	private void webSearch(String query){

	}

}
