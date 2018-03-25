package chapter03basical_program_structure;

import utils.MyUtils;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/19 16:50
 */
public class AutoCast {
    public static void main(String[] args) {
        int i = 3;
        i += 5.6; // 此句等价于 i = (int)(i + 5.6);
        System.out.println(MyUtils.getCurrentTime() + "i = " + i);//    i = 8

        System.out.println(MyUtils.getCurrentTime() + "Math.round(9.5) = " + Math.round(9.5));//10
    }
}
