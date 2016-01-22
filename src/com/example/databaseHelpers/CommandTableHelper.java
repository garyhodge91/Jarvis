package com.example.databaseHelpers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jarvis.Command;

public class CommandTableHelper {
	
	private static final String TABLE_COMMAND = "COMMAND";
	private static final String KEY_TITLE = "TITLE";
	private static final String KEY_CREATE_DATE = "CREATED_DATE";
	private static final String KEY_IS_ACTIVE = "IS_ACTIVE";
	private static final String KEY_LAST_RAN_DATE = "LAST_RAN_DATE";
	private static final String KEY_LAST_MODIFIED_DATE = "LAST_MODIFIED_DATE";
	private static final String KEY_UTTERANCE = "UTTERANCE";
	private static final String KEY_IS_DELETED = "IS_DELETED";
	private static final String KEY_ID = "ID";
	private static final String KEY_DESCRIPTION = "DESCRIPTION";
	
	public long createCommand(Command command, DatabaseHelper db){
		SQLiteDatabase database = db.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_TITLE, command.getTitle());
		values.put(KEY_CREATE_DATE, command.getCreatedDate());
		values.put(KEY_IS_ACTIVE, command.getIsActive());
		values.put(KEY_LAST_RAN_DATE, command.getLastRanDate());
		values.put(KEY_LAST_MODIFIED_DATE, command.getLastModifiedDate());
		values.put(KEY_UTTERANCE, command.getUtterance());
		values.put(KEY_IS_DELETED, command.getIsDeleted());
		values.put(KEY_DESCRIPTION, command.getDescription());
		
		long commandId = database.insert(TABLE_COMMAND, null, values);
		
		return commandId;
	}
	
	public Command getCommand(long CommandId, DatabaseHelper db){
		SQLiteDatabase database = db.getReadableDatabase();
		
		String query = "SELECT * FROM " + TABLE_COMMAND + " WHERE " + KEY_ID + " = " + CommandId;
		
		Cursor c = database.rawQuery(query, null);
		
		if(c != null){
			c.moveToFirst();
			Command command = new Command();
			command.loadCommand(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_TITLE)),
					c.getString(c.getColumnIndex(KEY_CREATE_DATE)),c.getString(c.getColumnIndex(KEY_LAST_RAN_DATE)),
					c.getString(c.getColumnIndex(KEY_LAST_MODIFIED_DATE)),c.getString(c.getColumnIndex(KEY_UTTERANCE)),
					c.getString(c.getColumnIndex(KEY_IS_DELETED)),c.getString(c.getColumnIndex(KEY_IS_ACTIVE)),
					c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
			return command;
		
		}
		return null;
	}
	
	public List<Command> getCommands(DatabaseHelper db, String isActive, String isDeleted, String orderBy){
		List<Command> commands = new ArrayList<Command>();
		SQLiteDatabase database = db.getReadableDatabase();
		
		String whereClause = "WHERE " + KEY_IS_ACTIVE  + " = '" + isActive + "' AND " + KEY_IS_DELETED + " = '" + isDeleted + "'";
		String query = "SELECT * FROM " + TABLE_COMMAND + " " + whereClause;
		
		Cursor c = database.rawQuery(query, null);
		
		for(int i = 1; i <= c.getCount(); i++){
			c.move(i);
			Command command = new Command();
			command.loadCommand(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_TITLE)),
					c.getString(c.getColumnIndex(KEY_CREATE_DATE)),c.getString(c.getColumnIndex(KEY_LAST_RAN_DATE)),
					c.getString(c.getColumnIndex(KEY_LAST_MODIFIED_DATE)),c.getString(c.getColumnIndex(KEY_UTTERANCE)),
					c.getString(c.getColumnIndex(KEY_IS_DELETED)),c.getString(c.getColumnIndex(KEY_IS_ACTIVE)),
					c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
			commands.add(command);
		}
	return commands;
		
	}
	
	public int updateCommand(Command command, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_TITLE, command.getTitle());
		values.put(KEY_CREATE_DATE, command.getCreatedDate());
		values.put(KEY_IS_ACTIVE, command.getIsActive());
		values.put(KEY_LAST_RAN_DATE, command.getLastRanDate());
		values.put(KEY_LAST_MODIFIED_DATE, command.getLastModifiedDate());
		values.put(KEY_UTTERANCE, command.getUtterance());
		values.put(KEY_IS_DELETED, command.getIsDeleted());
		values.put(KEY_DESCRIPTION, command.getDescription());
		
		return database.update(TABLE_COMMAND, values, KEY_ID + "= ?", new String[] {String.valueOf(command.getId())});
		
	}
	
	public void deleteCommand(long commandId, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		database.delete(TABLE_COMMAND, KEY_ID + "= ?", new String[] {String.valueOf(commandId)});
	}

}
