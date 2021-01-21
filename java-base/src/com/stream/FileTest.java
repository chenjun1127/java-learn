package com.stream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/20 16:15
 */
public class FileTest {
    private static final String dirname = "D:\\work_space\\java-learn\\java-base";
    private static final String pathname = "test.txt";

    public static void main(String[] args) {
        getFiles();
        createAndWriteFile();
        scheduleTask();
    }

    /**
     * 获取磁盘文件、判断是否是文件还是文件夹
     */
    private static void getFiles() {
        File file = new File(dirname);
        if (file.isDirectory()) {
            System.out.println("Directory of " + dirname);
            String[] s = file.list();
            assert s != null;
            for (String value : s) {
                File f = new File(dirname + "/" + value);
                if (f.isDirectory()) {
                    System.out.println(value + " is a directory");
                } else {
                    System.out.println(value + " is a file");
                }
            }
        } else {
            System.out.println(dirname + " is not a directory");
        }
    }

    /**
     * 创建读取文件
     */
    private static void createAndWriteFile() {
        String fileDirname = dirname + "\\" + pathname;
        String content = "hello world";
        File file = new File(fileDirname);
        try {
            if (file.createNewFile()) {
                System.out.println("创建成功");
                Files.write(Paths.get(fileDirname), content.getBytes());
            } else {
                System.out.println("文件已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 删除文件
     */
    private static void deleteFile(String path, String type) {
        File file = new File(path);
        File temp = null;
        File[] fileList = file.listFiles();
        for (int i = 0; i < (fileList != null ? fileList.length : 0); i++) {
            temp = fileList[i];
            if (temp.getName().endsWith(type)) {
                try {
                    Files.delete(Paths.get(path + "\\" + temp.getName()));
                    System.out.println("删除文件成功，文件路径：" + path + "\\" + temp.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("删除文件失败");
                }
            }
        }
    }
    /**
     * 定时任务
     */
    private static void scheduleTask() {
        // 时间间隔
        long PERIOD_DAY = 24 * 60 * 60 * 1000;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        System.out.println(date);
        // 如果第一次执行定时任务的时间小于当前的时间
        // 此时要在第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
        if (date.before(new Date())) {
            date = addDay(date, 1);
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("----设定要指定任务-----");
                deleteFile(dirname, "txt");
            }
        }, date, PERIOD_DAY);
    }

    /**
     * 增加或减少天数
     */
    private static Date addDay(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, i);
        return calendar.getTime();
    }
}
