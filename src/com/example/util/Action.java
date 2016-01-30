package com.example.util;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.actions.ActionDef;
import com.example.actions.IActionDef;

public class Action implements Parcelable{
	private int id;
	private int commandId;
	private int actionDefId;
	private String param1;
	private String param2;
	private String param3;
	private String actionDef;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	public int getActionDefId() {
		return actionDefId;
	}

	public void setActionDefId(int actionDefId) {
		this.actionDefId = actionDefId;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}
	
	public String getActionDef() {
		return actionDef;
	}

	public void setActionDef(String actionDef) {
		this.actionDef = actionDef;
	}

	public Action createAction(int commandId, int actionDefId, String param1, String param2, String param3){
		this.commandId = commandId;
		this.actionDefId = actionDefId;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		return this;
	}
	public Action loadAction(int id, int commandId, int actionDefId, String param1, String param2, String param3){
		this.id = id;
		this.commandId = commandId;
		this.actionDefId = actionDefId;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		return this;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(id);
		dest.writeInt(commandId);
		dest.writeInt(actionDefId);
		dest.writeString(param1);
		dest.writeString(param2);
		dest.writeString(param3);
		
	}
	
	protected Action readFromParcel(Parcel in) {
		this.id = in.readInt();
		this.commandId = in.readInt();
		this.actionDefId = in.readInt();
		this.param1 = in.readString();
		this.param2 = in.readString();
		this.param3 = in.readString();
		return this;
	}
	
	public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() {

		@Override
		public Action createFromParcel(Parcel in) {
			// TODO Auto-generated method stub
			Action action = new Action();
			return action.readFromParcel(in);
		}

		@Override
		public Action[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Action[size];
		}
	};

	

}
