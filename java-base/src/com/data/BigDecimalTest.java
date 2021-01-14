package com.data;

import java.math.BigDecimal;

/**
 * @Description: 主要用于大数据，精度极高，引用类型
 * @Author: chenjun
 * @Date: 2021/1/14 13:50
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal p1 = new BigDecimal(100);
        BigDecimal p2 = new BigDecimal(200);

        System.out.println("求和：" + p1.add(p2));
        System.out.println("除法：" + p1.divide(p2, 1, BigDecimal.ROUND_HALF_UP));
    }
}
