package com.reflect.entities;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/12/18 14:27
 */
public class Book {
    private static final String tag = "Java related books";
    private String name;
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public static String getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String declaredMethod(int index) {
        String string = null;
        if (index == 0) {
            string = "I am declaredMethod 1 !";
        } else {
            string = "I am declaredMethod 2 !";
        }
        return string;
    }
}
