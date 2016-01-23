package com.example.databaseHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final int DATABASE_VERSION = 1;
	
	private  static final String DATABASE_NAME = "jarvis";
	
	// Commands table
		private static final String TABLE_COMMAND = "COMMAND";
		private static final String KEY_TITLE = "TITLE";
		private static final String KEY_CREATE_DATE = "CREATED_DATE";
		private static final String KEY_IS_ACTIVE = "IS_ACTIVE";
		private static final String KEY_LAST_RAN_DATE = "LAST_RAN_DATE";
		private static final String KEY_LAST_MODIFIED_DATE = "LAST_MODIFIED_DATE";
		private static final String KEY_UTTERANCE = "UTTERANCE";
		private static final String KEY_IS_DELETED = "IS_DELETED";
		
		
	// Action table
		private static final String TABLE_ACTION = "ACTION";
		private static final String KEY_COMMAND_ID = "COMMAND_ID";
		private static final String KEY_ACTION_DEF_ID = "ACTION_DEF_ID";
		private static final String KEY_PARAM_1 = "PARAM_1";
		private static final String KEY_PARAM_2 = "PARAM_2";
		private static final String KEY_PARAM_3 = "PARAM_3";
		
	// Action Def table
		private static final String TABLE_ACTION_DEF = "ACTION_DEF";
		private static final String KEY_CATEGORY = "CATEGORY";
		private static final String KEY_TYPE = "TYPE";
		private static final String KEY_DISPLAY_NAME = "DISPLAY_NAME";
		
	// Common keys
		private static final String KEY_ID = "ID";
		private static final String KEY_DESCRIPTION = "DESCRIPTION";
		
		private static final String CREATE_TABLE_MOMENTS = "CREATE TABLE " + TABLE_COMMAND + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ KEY_TITLE +" TEXT, " + KEY_UTTERANCE + " TEXT," + KEY_CREATE_DATE + " DATETIME, " + KEY_IS_ACTIVE + " CHAR, " + KEY_LAST_RAN_DATE
				+ " DATETIME, " + KEY_LAST_MODIFIED_DATE + " DATETIME, " + KEY_DESCRIPTION + "CHAR, " + KEY_IS_DELETED + " CHAR)"; 
		
		private static final String CREATE_TABLE_ACTION_DEF = "CREATE TABLE " + TABLE_ACTION_DEF + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ KEY_CATEGORY + " TEXT, " + KEY_DESCRIPTION + " TEXT, " + KEY_TYPE +  " TEXT, " + KEY_DISPLAY_NAME + " TEXT) "; 
		
		private static final String CREATE_TABLE_ACTIONS = "CREATE TABLE " + TABLE_ACTION + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ KEY_ACTION_DEF_ID + " INTEGER, " + KEY_PARAM_1 + " TEXT, " + KEY_PARAM_2 + " TEXT, " + KEY_PARAM_3 + " TEXT, " + KEY_IS_DELETED + " CHAR, " + KEY_COMMAND_ID + 
				" INTEGER, FOREIGN KEY(" + KEY_COMMAND_ID + ") REFERENCES " + TABLE_COMMAND+ "(" + KEY_ID + "))"; 



	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_MOMENTS);
		db.execSQL(CREATE_TABLE_ACTIONS);
		db.execSQL(CREATE_TABLE_ACTION_DEF);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
