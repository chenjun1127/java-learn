package com.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: 编程实现文件拷贝，下面代码给出了两种实现方案
 * @Author: chenjun
 * @Date: 2021/1/21 16:02
 */
public class FileUtil {

    public static void fileCopy(String source, String target) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(source);
        FileOutputStream fileOutputStream = new FileOutputStream(target);
        byte[] bytes = new byte[4096];
        int length;
        while ((length = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, length);
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(source);
        FileOutputStream fileOutputStream = new FileOutputStream(target);
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
    }
}
