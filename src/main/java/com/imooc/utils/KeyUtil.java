package com.imooc.utils;

import java.util.Random;

/**
 * @author Louis
 * @date Create in 2019/11/5 19:26
 */
public class KeyUtil {
    /**
     * 生成唯一的主键：时间+随机数
     * @return String
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
