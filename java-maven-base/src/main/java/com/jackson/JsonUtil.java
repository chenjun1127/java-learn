package com.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 * @Description: Json通用工具类，使用Jackson
 * @Author: chenjun
 * @Date: 2021/3/4 16:29
 */
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final static Logger logger = Logger.getLogger(String.valueOf(JsonUtil.class));

    static {
        // 对象的所有字段全部列入
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        // 取消默认转换timestamps形式
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 忽略空Bean转Json的错误
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm: ss
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));
        // 忽略在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> String objToString(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.warning("Parse Object to String error");
            return null;
        }
    }

    public static <T> String objToStringPretty(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.warning("Parse Object to String error");
            return null;
        }
    }

    public static <T> T stringToObj(String str, Class<T> clazz) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : OBJECT_MAPPER.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.warning("Parse String to Object error");
            return null;
        }
    }

    /**
     * @Description: typeReference具体的类型
     * @Return T
     */
    public static <T> T stringToObj(String str, TypeReference<T> typeReference) {
        if (typeReference == null || str == null || str.length() == 0) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? str : OBJECT_MAPPER.readValue(str, typeReference));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.warning("Parse String to Object error");
            return null;
        }
    }
    /**
     * @Description: 可变长参数
     * @Return T
     */
    public static <T> T stringToObj(String str, Class<?> collectionClass, Class<?>... elementClasses) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        try {
            return OBJECT_MAPPER.readValue(str, javaType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.warning("Parse String to Object error");
            return null;
        }
    }
}
