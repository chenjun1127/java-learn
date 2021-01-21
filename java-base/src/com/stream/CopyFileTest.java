package com.stream;

import java.io.IOException;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/21 16:15
 */
public class CopyFileTest {
    private static final String dirname = "D:\\work_space\\java-learn\\java-base";

    public static void main(String[] args) {
        try {
            FileUtil.fileCopyNIO(dirname + "\\test.txt", dirname + "\\test1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
