package com.zaidock.chat.utills;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Config {

	public static Properties prop = new Properties();

	public void set(String title, String value) {
		try {
			prop.setProperty(title, value);
			prop.store(new FileOutputStream("chatopia.file"), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String get(String title) {
		String value = "";

		try {
			prop.load(new FileInputStream("chatopia.file"));
			value = prop.getProperty(title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
