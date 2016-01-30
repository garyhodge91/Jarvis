package com.example.jarvis;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.actions.vibrateActionDef;
import com.example.util.Action;
import com.example.util.Command;
import com.example.util.SharedPreferencesHelper;
import com.google.gson.*;;
//import com.google.gson.JsonArray;
//import com.google.gson.*;

public class AddNewCommand extends Activity implements OnClickListener{

	Button done;
	EditText utterance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_command);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		done = (Button)findViewById(R.id.done);
		done.setOnClickListener(this);
		
		utterance = (EditText) findViewById(R.id.utterance);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.done:
			Command command = new Command();
			command.createCommand("Test", new Date().toString(), new Date().toString(), new Date().toString(), utterance.getText().toString(), "N", "Y", "New test command");
			Action action = new Action();
			action.createAction(1, 1, "", "", "");
//			ArrayList<ActionDef> actionDefs = new ArrayList<ActionDef>();
//			actionDefs.add(new vibrateActionDef());
			action.setActionDef(new vibrateActionDef().getClass().getName());
			ArrayList<Action> actions = new ArrayList<Action>();
			actions.add(action);
			command.setActions(actions);
			Gson gson = new Gson();
			String commandJson = gson.toJson(command);
//			JSONArray jsonArray = new JSONArray();
//			jsonArray.put(commandJson);
//			String jsonString = SharedPreferencesHelper.getSharedPreferencesString(this, "commands", "");
				SharedPreferencesHelper.putSharedPreferencesString(this, "commands", commandJson);

			setResult(RESULT_OK);
			finish();
		
		}
	}

}
