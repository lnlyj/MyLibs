package com.wl.libs.util;

import java.util.Random;

/**
 * Created by wanglei on 16/7/1.
 */
public class CommenUtil {

    /**
     * @Description: 获取6位随机数
     *
     * @author wanglei
     * @date 16/7/1 10:50
     */
    public static String getCode() {
        return getCode(6);
    }

    /**
     * 获取随机数
     * 
     * @param count 随机数位数
     * @author wanglei
     * @date 16/7/1 10:51
     */
    public static String getCode(int count) {
        char start = '0';
        char end = '9';

        Random rnd = new Random();

        char[] result = new char[count];
        int len = end - start + 1;

        while (count-- > 0) {
            result[count] = (char) (rnd.nextInt(len) + start);
        }

        return new String(result);
    }

}
