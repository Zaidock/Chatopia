package com.zaidock.chat;

import org.json.JSONObject;

public class JSONTools {
	
	static JSONObject reader;

	public static String get(String filepath, String type){
		reader = new JSONObject(filepath);
		
		String out = reader.getString(type);
		return out;
	}
	
	public static String getFromObject(String filepath, String object, String type){
		reader = new JSONObject(filepath);
		
		String out = reader.getJSONObject(object).getString(type);
		return out;
	}
	
}
