package com.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.entities.Girl;
import org.json.JSONObject;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/5 10:42
 */
public class JsonTest {
    public static void main(String[] args) {
        createJson();
        createJsonByMap();
        createJsonByJavaBean();
    }

    /**
     * @Description: 直接构建
     * @Return void
     */
    public static void createJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Lucy");
        jsonObject.put("hobbies", new String[]{"yoga", "swimming"});
        jsonObject.put("age", 26);
        jsonObject.put("boyfriend", (Object) null);
        jsonObject.put("birthday", "1996-02-15");
        jsonObject.put("createTime", new Date());
        jsonObject.put("features", new HashMap<String, Integer>() {
            private static final long serialVersionUID = 1L;

            {
                put("height", 170);
                put("weight", 50);
            }
        });
        System.out.println("直接生成Json:\n" + jsonObject.toString() + "\n");
    }

    /**
     * @Description: map方式生成json
     * @Return void
     */
    public static void createJsonByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Integer> features = new HashMap<String, Integer>();
        features.put("height", 170);
        features.put("weight", 50);
        map.put("name", "Lucy");
        map.put("hobbies", new String[]{"yoga", "swimming"});
        map.put("age", 26);
        map.put("boyfriend", null);
        map.put("features", features);
        map.put("birthday", "1996-02-15");
        map.put("createTime", new Date());
        JSONObject jsonObject = new JSONObject(map);
        System.out.println("通过Map对象生成json：\n" + jsonObject.toString() + "\n");
    }

    /**
     * @Description: 通过javabean生成json
     * @Return void
     */
    public static void createJsonByJavaBean() {
        JSONObject jsonObject = new JSONObject(createGirl());
        System.out.println("通过javabean生成json：\n" + jsonObject.toString() + "\n");
    }
    /**
     * @Description: 生成girl对象
     * @Return com.entities.Girl
     */
    public static Girl createGirl() {
        Girl girl = new Girl();
        girl.setName("Lucy");
        girl.setAge(26);
        girl.setFeatures(new HashMap<>(16) {
            private static final long serialVersionUID = 1L;

            {
                put("height", 170);
                put("weight", 50);
            }
        });
        girl.setBirthday("1996-02-15");
        return girl;
    }

}
