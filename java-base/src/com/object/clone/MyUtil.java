package com.object.clone;

import java.io.*;

/**
 * @Description: 基于序列化和反序列化实现的深度克隆，
 * @Author: chenjun
 * @Date: 2021/1/21 14:27
 */
public class MyUtil {
    private MyUtil() {
        throw new AssertionError();
    }

    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (T) objectInputStream.readObject();
    }
}
