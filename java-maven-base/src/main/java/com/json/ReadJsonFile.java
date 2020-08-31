package com.json;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author chenjun 
 * 2020��6��19�� ����9:57:48 ��ȡ�ļ�
 */
public class ReadJsonFile {

	public static void main(String[] args) throws IOException, JSONException {
		File file = new File(ReadJsonFile.class.getResource("person.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		System.out.println(jsonObject);
		System.out.println("�����ǣ�" + jsonObject.getString("name"));
		JSONArray jsonArr = jsonObject.getJSONArray("hobbies");		
		for (int i = 0; i < jsonArr.length(); i++) {
			String s = (String) jsonArr.get(i);
			System.out.println("�����ǣ�" + s);
		}
	}
}
