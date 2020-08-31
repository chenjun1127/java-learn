package com.gson;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.json.Girl;

public class GsonTest {
	public static void main(String[] args) {
		Girl girl = new Girl();
		girl.setName("Lcuy");
		girl.setAge(26); 
		girl.setFeatures(new HashMap<String, Integer>() {
			private static final long serialVersionUID = 1L;
			{
				put("height", 170);
				put("weight", 50);
			}
		}); 
		girl.setBoyfriend(null);
		girl.setHobbies(new String[] { "yoga", "swimming" });
		girl.setBirthday("1996-02-15");
		girl.setCreateTime(new Date());
		createJsonWithGsonMain(girl);
		createJsonWithGsonBeautify(girl);
		createJsonWithGsonChangeFields(girl);
	}

	/*
	 * 	ͨ��javaben����json
	 */

	public static void createJsonWithGsonMain(Object obj) {
		Gson gson = new Gson();
		System.out.println("ͨ��javaben����json��\n" + gson.toJson(obj) + "\n");
	}

	public static void createJsonWithGsonBeautify(Object obj) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		System.out.println("������json��\n" + gson.toJson(obj) + "\n");
	}

	/**
	 * @param obj
	 * 	��д�ֶΣ���ʽ��ʱ��
	 */
	public static void createJsonWithGsonChangeFields(Object obj) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {

			@Override
			public String translateName(Field f) {
				if (f.getName().equals("name")) {
					return "NAME";
				}
				return f.getName();
			}
		});
		Gson gson = gsonBuilder.create();
		System.out.println("�ı���json�ֶθ�ʽ��ʱ�䣺\n" + gson.toJson(obj) + "\n"); 
	}
}
