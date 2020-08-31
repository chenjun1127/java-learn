package com.sql;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sql.Person;

/**
 * @author chenjun
 * 2020��6��19�� ����6:40:45
 * mysql���Բ�����json
 */
public class SqlTest {
	// MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Shanghai";

	// ���ݿ���û��������룬��Ҫ�����Լ�������
	static final String USER = "root";
	static final String PASS = "123456";
	public static ArrayList<Person> list = new ArrayList<Person>();

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			// ������
			System.out.println("�������ݿ�...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// ִ�в�ѯ
			System.out.println(" ʵ����Statement����...");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				int age = rs.getInt("age");
				String[] hobbies = rs.getString("hobbies").split(",");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("create_time"));
				String birthday = rs.getString("birthday");
				String work = rs.getString("work");
				String country = rs.getString("country");
				// �������
				System.out.print("ID: " + id);
				System.out.print(", ����: " + name);
				System.out.print(", ����: " + age);
				System.out.print(", ������ҳ: " + url);
				System.out.print(", ����: " + Arrays.toString(hobbies));
				System.out.print(", ���: " + height);
				System.out.print(", ����: " + weight);
				System.out.print(", ����ʱ��: " + createTime);
				System.out.print(", ��������: " + birthday);
				System.out.print(", ְҵ: " + work);
				System.out.print(", ����: " + country);
				System.out.print("\n");
				Person p = new Person();
				p.setName(name);
				p.setAge(age);
				p.setUrl(url);
				p.setCountry(country);
				p.setBirthday(birthday);
				p.setHobbies(hobbies);
				p.setWork(work);
				Map<String, Integer> features = new HashMap<String, Integer>();
				features.put("height", height);
				features.put("weight", weight);
				p.setFeatures(features);
				list.add(p);
			}
			// ����json
			createJson(list);
			// ��ɺ�ر�
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}

	public static <ArrrayList> void createJson(ArrrayList list) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String jsonStr = gson.toJson(list);
		System.out.println(jsonStr);
	}
}
