package com.stream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description: 文件输入流、输出流
 * @Author: chenjun
 * @Date: 2021/1/20 17:49
 */
public class FileStreamTest {
    private static final String pathname = "D:\\work_space\\java-learn\\java-base\\test.txt";
    private static final int size = 1024;

    public static void main(String[] args) {
        fileInputStreamWrite();
        fileInputStreamRead();
    }
    /**
     * 写入文件
     */
    private static void fileInputStreamWrite() {
        File file = new File(pathname);
        if (!file.exists()) {
            try {
                Files.createFile(Paths.get(pathname));
                System.out.println("创建文件成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            String content = "写入文件测试";
            byte[] bytes = content.getBytes();
            try {
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                System.out.println("写入完成!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取文件
     */
    private static void fileInputStreamRead() {
        File file = new File(pathname);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[size]; // 数据中转站 临时缓冲区
            int length = 0;
            // 循环读取文件内容，输入流中将最多bytes.length个字节的数据读入一个bytes数组中,返回类型是读取到的字节数。
            // 当文件读取到结尾时返回 -1,循环结束。
            while ((length = fileInputStream.read(bytes)) != -1) {
                System.out.println("读取到的内容为：" + new String(bytes, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
