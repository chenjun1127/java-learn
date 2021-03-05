package com.jackson;

import com.entities.Girl;

import java.util.logging.Logger;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/4 17:58
 */
public class JacksonTest {
    private final static Logger logger = Logger.getLogger(String.valueOf(JacksonTest.class));

    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.setAge(20);
        girl.setName("Lucy");
        String girlJson = JsonUtil.objToString(girl);
        String girlJsonPretty = JsonUtil.objToStringPretty(girl);
        logger.info(girlJson);
        Girl girl1 = JsonUtil.stringToObj(girlJsonPretty, Girl.class);
        logger.info(girl1.toString());
    }
}
