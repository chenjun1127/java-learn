package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        Score s = new Score();
        s.calcAverage();
        s.scoreSort();
    }
}

class Score {
    public int[][] scores = {{80, 70, 65}, {50, 60, 35}, {120, 80, 90}};
    // 数组两种声明方式，下面这种也可以
    // public int[][] scores = {{80, 70, 65}, {50, 60, 35}, {120, 80, 90}};

    public void calcAverage() {
        int sum = 0;
        int length = 0;
        for (int[] arr : this.scores) {
            length += arr.length;
            for (int n : arr) {
                sum += n;
            }
        }
        System.out.println("学生的平均分为：" + sum / length);
    }

    public void scoreSort() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int[] arr : scores) {
            for (int j : arr) {
                list.add(j);
            }
        }
//		将arrayList转换为array;
        Integer[] ns = list.toArray(new Integer[0]);
        System.out.println("排序前：" + Arrays.toString(ns));

        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j + 1]) {
                    int temp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = temp;
                }
            }
        }
// 		Arrays.sort(ns);// 也可用内置的排序
        System.out.println("排序后：" + Arrays.toString(ns));
    }
}
