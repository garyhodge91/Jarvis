package com.example.util;

import android.os.Parcel;
import android.os.Parcelable;

public class ActionDef implements Parcelable{
	private int id;
	private String category;
	private String description;
	private String type;
	private String displayName;

	
	public ActionDef createAction(String category, String description, String type, String displayName){
		this.category = category;
		this.description = description;
		this.type = type;
		this.displayName = displayName;
		return this;
	}
	public ActionDef loadAction(int id, String category, String description, String type, String displayName){
		this.id = id;
		this.category = category;
		this.description = description;
		this.type = type;
		this.displayName = displayName;
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
		dest.writeString(category);
		dest.writeString(description);
		dest.writeString(type);
		dest.writeString(displayName);
		
	}
	
	protected ActionDef readFromParcel(Parcel in) {
		this.id = in.readInt();
		this.category = in.readString();
		this.description = in.readString();
		this.type = in.readString();
		this.displayName = in.readString();
		return this;
	}
	
	public static final Parcelable.Creator<ActionDef> CREATOR = new Parcelable.Creator<ActionDef>() {

		@Override
		public ActionDef createFromParcel(Parcel in) {
			// TODO Auto-generated method stub
			ActionDef actionDef = new ActionDef();
			return actionDef.readFromParcel(in);
		}

		@Override
		public ActionDef[] newArray(int size) {
			// TODO Auto-generated method stub
			return new ActionDef[size];
		}
	};
	
	public void executeAction(){
		
	}

}
