package com.example.jarvis;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.actions.ActionDef;
import com.example.actions.IActionDef;
import com.example.util.Action;
import com.example.util.Command;
import com.example.util.SharedPreferencesHelper;
import com.google.gson.Gson;

public class CarryOutCommand {
	ArrayList<Command> commands = new ArrayList<Command>();
	public void findCommands(String utterance, Context context){
		
		
			String commandJson = SharedPreferencesHelper.getSharedPreferencesString(context,"commands", "");
		boolean found = false;
		Gson gson = new Gson();
		
//				for(int i = 0; i < commands.size(); i++){
					Command command = gson.fromJson(commandJson, Command.class);
//					Command command = (Command) obj; 
//					if(command.getUtterance().equals(utterance)){
						found = true;
						for(int j = 0; j < command.getActions().size(); j++){
							Action action = command.getActions().get(j);
							String actionDefName = action.getActionDef();
							IActionDef actionDef;
							try {
								actionDef = (IActionDef) Class.forName(actionDefName).newInstance();
								actionDef.execute(action.getParam1(), action.getParam2(), action.getParam3(), context);
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
//							actionDef.getMethod("execute", parameterTypes)
//							for(ActionDef actionDef : actionDefs){
								//ActionDef actionDef = actionDefs.get(k);
								
//							}
						}
//					}
//				}

		if(!found){
			webSearch(context,utterance);
		}

	}


	private void webSearch(Context context, String query){
		try {
			query = URLEncoder.encode(query, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "http://www.google.com/search?q=" + query;
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);

	}

}
