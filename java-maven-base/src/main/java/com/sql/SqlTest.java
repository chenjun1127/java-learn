package com.sql;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author chenjun
 * 2020年6月19日 下午6:40:45
 * mysql测试并返回json
 */
public class SqlTest {
	// MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Shanghai";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";
	public static java.util.ArrayList<Person> list = new java.util.ArrayList<Person>();

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// 执行查询
			System.out.println(" 实例化Statement对象...");
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
				// 输出数据
				System.out.print("ID: " + id);
				System.out.print(", 姓名: " + name);
				System.out.print(", 年龄: " + age);
				System.out.print(", 个人主页: " + url);
				System.out.print(", 爱好: " + Arrays.toString(hobbies));
				System.out.print(", 身高: " + height);
				System.out.print(", 体重: " + weight);
				System.out.print(", 创建时间: " + createTime);
				System.out.print(", 出生年月: " + birthday);
				System.out.print(", 职业: " + work);
				System.out.print(", 国籍: " + country);
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
			// 生成json
			createJson(list);
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
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

	public static <ArrayList> void createJson(ArrayList list) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String jsonStr = gson.toJson(list);
		System.out.println(jsonStr);
	}
}
