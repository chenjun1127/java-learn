package com.object.clone.entities;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/21 14:03
 */
public class Student implements Cloneable {
    private int number;
    private int id;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", id=" + id +
                '}';
    }
}
