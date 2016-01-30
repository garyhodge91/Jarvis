package com.example.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesHelper {
	private static String prefs = "JarvisSP";
	public static void putSharedPreferencesString(Context context, String key, String val){
        SharedPreferences preferences= context.getSharedPreferences(prefs, Context.MODE_MULTI_PROCESS);
        Editor editor=preferences.edit();
        editor.putString(key, val).commit(); // puts the preference into the SharedPreferences
    }
	
	public static String getSharedPreferencesString(Context context, String key, String _default){
		SharedPreferences preferences= context.getSharedPreferences(prefs, Context.MODE_MULTI_PROCESS);
        return preferences.getString(key, _default); // gets the preference from the SharedPreferences
    }
	
	public static void removeKey(Context context, String key){
		SharedPreferences preferences= context.getSharedPreferences(prefs, Context.MODE_MULTI_PROCESS);
        Editor editor=preferences.edit();
        editor.remove(key).commit(); // removed the preference from the SharedPreferences
	}

}
