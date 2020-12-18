package com.reflect;

import com.reflect.entities.Book;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @Description: java反映 参考：https://www.jianshu.com/p/9be58ee20dee
 * @Author: chenjun
 * @Date: 2020/12/18 14:33
 */
public class ReflectClass {

    private static final Logger logger = Logger.getLogger("ReflectClass.log");

    // 创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.reflect.entities.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setAuthor("周志明");
            book.setName("深入理解Java虚拟机 第2版");
            logger.info("reflectNewInstance book = " + book.toString());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // 反射私有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.reflect.entities.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            // declaredConstructorBook类中的成员变量为private,故必须进行此操作
            declaredConstructorBook.setAccessible(true);
            Book book = (Book) declaredConstructorBook.newInstance("深入理解Java虚拟机 第2版", "周志明");
            logger.info("reflectPrivateConstructor book = " + book.toString());
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.reflect.entities.Book");
            Field field = classBook.getDeclaredField("tag");
            field.setAccessible(true);
            String tag = (String) field.get(classBook);
            logger.info("reflectPrivateField tag = " + tag);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.reflect.entities.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook, 0);
            logger.info("reflectPrivateMethod string = " + string);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }
}
