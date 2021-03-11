package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: 链式编程(stream并行流)
 * @Author: chenjun
 * @Date: 2021/3/10 17:01
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        String[] s = new String[]{"a", "b", "c", "d", "e", "f"};
        for (int i = 1; i <= 6; i++) {
            userList.add(new User(i, s[i - 1], 20 + i));
        }
        // 1、取偶数
        // 2、年龄大于23的
        // 3、名字大写
        // 4、用户名字母倒叙
        // 5、只输出一个
        userList.stream().filter(user -> user.getId() % 2 == 0).filter(user -> user.getAge() > 23).map(user -> user.getName().toUpperCase()).sorted(Comparator.reverseOrder()).limit(1).forEach(System.out::println);
    }
}
