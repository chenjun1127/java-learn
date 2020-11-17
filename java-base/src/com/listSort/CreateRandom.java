package com.listSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CreateRandom {
    public List<Integer> integerList;
    public List<String> stringList;

    public CreateRandom() {
        this.integerList = new ArrayList<Integer>();
        this.stringList = new ArrayList<String>();
    }

    public void sort() {
        Collections.sort(this.stringList);
    }

    public <T extends Comparable<? super T>> void mainSort(List<T> list) {
        Collections.sort(list);
    }

    public void createRandomIntList() {
//		生成唯一不重复随机整数
        Random random = new Random();
        int k;
        for (int i = 0; i < 10; i++) {
            do {
                k = random.nextInt(100);
            } while (this.integerList.contains(k));
            this.integerList.add(k);
        }
    }

    public void createRandomStringList() {
        for (int i = 0; i < 10; i++) {
            this.stringList.add(this.getRandomStr(6));
        }
    }

    /**
     * 生成随机字符串
     */
    public String getRandomStr(int length) {
        Random random = new Random();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            char charAt = str.charAt(number);
            sb.append(charAt);
        }
        return sb.toString();
    }

    public <T> void printSortBefore(List<T> T) {
        System.out.println("=======排序前==========");
        System.out.println(T);
//		for (String s : this.stringList) {
//			System.out.println(s);
//		}
    }

    public <T> void printSortAfter(List<T> T) {
        System.out.println("=======排序后==========");
        System.out.println(T);
    }
}
