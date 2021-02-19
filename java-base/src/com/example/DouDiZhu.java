package com.example;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description: 斗地主
 * @Author: chenjun
 * @Date: 2021/2/5 14:34
 */
public class DouDiZhu {
    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        poker.add("大王");
        poker.add("小王");
        // 生成Poker
        for (String color : colors) {
            for (String number : numbers) {
                poker.add(color + number);
            }
        }
        // 洗牌，所有元素随机排序，使用shuffle方法
        Collections.shuffle(poker);
        System.out.println("洗牌之后的牌：" + poker);
        // 发牌
        ArrayList<String> play01 = new ArrayList<>();
        ArrayList<String> play02 = new ArrayList<>();
        ArrayList<String> play03 = new ArrayList<>();
        ArrayList<String> bottomCard = new ArrayList<>();
        int i = 0;
        for (String s : poker) {
            if (i >= 51) {
                bottomCard.add(s);
            } else if (i % 3 == 0) {
                play01.add(s);
            } else if (i % 3 == 1) {
                play02.add(s);
            } else if (i % 3 == 2) {
                play03.add(s);
            }
            i++;
        }
        System.out.println("玩家1的牌：" + play01);
        System.out.println("玩家2的牌：" + play02);
        System.out.println("玩家3的牌：" + play03);
        System.out.println("底牌：" + bottomCard);
    }
}
