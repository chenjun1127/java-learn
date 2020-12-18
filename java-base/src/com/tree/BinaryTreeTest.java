package com.tree;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/12/1 14:27
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10};
        System.out.println(binarySearch(arr, 7));
        System.out.println(Arrays.binarySearch(arr, 7));
    }

    /**
     * 二分查找算法(数据源必须是有序数组，每次迭代可以排除一半的结果), java.util.Arrays类已经实现了该方法，和下面类似
     */
    public static int binarySearch(Integer[] arr, Integer data) {
        int low = 0;
        int height = arr.length - 1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (arr[mid] < data) {
                low = mid + 1;
            } else if (arr[mid].equals(data)) {
                return mid;
            } else {
                height = mid - 1;
            }
        }
        return -1;
    }
}
