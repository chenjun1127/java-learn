package com.json;

import java.util.Date;
import java.util.Map;

public class Girl {
	public String name;
	public boolean female = true;
	public String[] hobbies;

	public int age;
	public Object boyfriend;
	public Map<String, Integer> features;
	public String birthday;
	public Date createTime = new Date();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Object getBoyfriend() {
		return boyfriend;
	}

	public void setBoyfriend(Object boyfriend) {
		this.boyfriend = boyfriend;
	}

	public Map<String, Integer> getFeatures() {
		return features;
	}

	public void setFeatures(Map<String, Integer> features) {
		this.features = features;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
