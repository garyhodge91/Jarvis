package com.example.jarvis;

import android.os.Parcel;
import android.os.Parcelable;

public class Command implements Parcelable {
	private int id;
	private String title;
	private String createdDate;
	private String lastRanDate;
	private String lastModifiedDate;
	private String utterance;
	private String isActive;
	private String isDeleted;
	private String description;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastRanDate() {
		return lastRanDate;
	}

	public void setLastRanDate(String lastRanDate) {
		this.lastRanDate = lastRanDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getUtterance() {
		return utterance;
	}

	public void setUtterance(String utterance) {
		this.utterance = utterance;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Command createCommand(String title, String createdDate,
			String lastRanDate, String lastModifiedDate, String utterance,
			String isDeleted, String isActive, String description) {
		this.title = title;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.lastRanDate = lastRanDate;
		this.utterance = utterance;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.description = description;
		return this;
	}
	
	public Command loadCommand(int id, String title, String createdDate,
			String lastRanDate, String lastModifiedDate, String utterance,
			String isDeleted, String isActive, String description){
		this.id = id;
		this.title = title;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.lastRanDate = lastRanDate;
		this.utterance = utterance;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.description = description;
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
		dest.writeString(title);
		dest.writeString(createdDate);
		dest.writeString(lastModifiedDate);
		dest.writeString(lastRanDate);
		dest.writeString(utterance);
		dest.writeString(isActive);
		dest.writeString(isDeleted);
		dest.writeString(description);
	}
	
	public Command readFromParcel(Parcel in){
		this.id = in.readInt();
		this.title = in.readString();
		this.createdDate = in.readString();
		this.lastModifiedDate = in.readString();
		this.lastRanDate = in.readString();
		this.utterance = in.readString();
		this.isActive = in.readString();
		this.isDeleted = in.readString();
		this.description = in.readString();
		
		return this;
	}
	
	public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator<Command>() {

		@Override
		public Command createFromParcel(Parcel in) {
			// TODO Auto-generated method stub
			Command command = new Command();
			return command.readFromParcel(in);
		}

		@Override
		public Command[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Command[size];
		}
	};

}
