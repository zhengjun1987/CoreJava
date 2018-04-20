package chapter02javaio;

import utils.MyUtils;

import java.nio.charset.StandardCharsets;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/20 11:31
 */
public class CharAndByte {
    public static void main(String[] args) {
        System.out.println(MyUtils.getCurrentTime() + "\"a\".getBytes().length = " + "a".getBytes(StandardCharsets.UTF_8).length);
        System.out.println(MyUtils.getCurrentTime() + "\"A\".getBytes().length = " + "A".getBytes().length);
        System.out.println(MyUtils.getCurrentTime() + "\"啊\".getBytes().length = " + "啊".getBytes().length);
        System.out.println(MyUtils.getCurrentTime() + "Character.BYTES = " + Character.BYTES);
    }
//            2018-04-20 11:32:52:922  "a".getBytes().length = 1
//            2018-04-20 11:32:52:953  "A".getBytes().length = 1
//            2018-04-20 11:32:52:953  "啊".getBytes().length = 3
}
