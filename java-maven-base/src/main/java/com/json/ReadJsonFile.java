package com.json;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author chenjun
 * 2020年6月19日 上午9:57:48 读取文件
 */
public class ReadJsonFile {

	public static void main(String[] args) throws IOException, JSONException {
		File file = new File(ReadJsonFile.class.getResource("/person.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		System.out.println(jsonObject);
		System.out.println("姓名是：" + jsonObject.getString("name"));
		JSONArray jsonArr = jsonObject.getJSONArray("hobbies");
		for (int i = 0; i < jsonArr.length(); i++) {
			String s = (String) jsonArr.get(i);
			System.out.println("爱好是：" + s);
		}
	}
}
