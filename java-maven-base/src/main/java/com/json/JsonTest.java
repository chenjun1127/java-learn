package com.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		createJson();
		createJsonByMap();
		createJsonByJavaBean();
	}

	/*
	 * 	ֱ�ӹ���
	 */
	public static void createJson() {
		JSONObject jsonObject = new JSONObject();
		Object nullObj = null;
		jsonObject.put("name", "Lucy");
		jsonObject.put("hobbies", new String[] { "yoga", "swimming" });
		jsonObject.put("age", 26);
		jsonObject.put("boyfriend", nullObj);
		jsonObject.put("brithday", "1996-02-15");
		jsonObject.put("createTime", new Date());
		jsonObject.put("features", new HashMap<String, Integer>() {
			private static final long serialVersionUID = 1L;
			{
				put("height", 170);
				put("weight", 50);
			}
		});
		System.out.println("ֱ������Json:\n" + jsonObject.toString() + "\n");
	}

	/**
	 * map��ʽ����json
	 */
	public static void createJsonByMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Integer> features = new HashMap<String, Integer>();
		features.put("height", 170);
		features.put("weight", 50);
		Object nullObj = null;
		map.put("name", "Lucy");
		map.put("hobbies", new String[] { "yoga", "swimming" });
		map.put("age", 26);
		map.put("boyfriend", nullObj);
		map.put("features", features);
		map.put("brithday", "1996-02-15");
		map.put("createTime", new Date());
		JSONObject jsonObject = new JSONObject(map);
		System.out.println("ͨ��Map��������json��\n" + jsonObject.toString() + "\n");
	}

	/*
	 * 	ͨ��javaben����json
	 */
	public static void createJsonByJavaBean() {
		Girl girl = new Girl();
		girl.setName("Lucy");
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
		JSONObject jsonObject = new JSONObject(girl);
		System.out.println("ͨ��javaben����json��\n" + jsonObject.toString() + "\n");
	}

}
