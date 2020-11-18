package com.list.sort;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/6/18 9:51
 */
public class RandomSort {
    public static void main(String[] args) {
        CreateRandom cr = new CreateRandom();
        cr.createRandomStringList();
        cr.printSortBefore(cr.stringList);
        cr.sort();
        cr.printSortAfter(cr.stringList);
        cr.createRandomIntList();
        cr.printSortBefore(cr.integerList);
        cr.mainSort(cr.integerList);
        cr.printSortAfter(cr.integerList);
    }
}
