package chapter03basical_program_structure;

import utils.MyUtils;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/3/18 13:25
 * Project:CoreJava
 */
public class FirstSample {
    public static void main(String[] args) {
        System.out.println("We will not use'Hello,World!'");
        System.out.println(MyUtils.getCurrentTime() + "0b1000_1001_1000 = " + 0b1000_1001_1000);
//        We will not use'Hello,World!'
//        2018-03-19 11:00:51:120  0b1000_1001_1000 = 2200
        //下划线只是为了易读,编译器在编译之前会清除掉这些下划线

        System.out.println(MyUtils.getCurrentTime() + "Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println(MyUtils.getCurrentTime() + "Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println(MyUtils.getCurrentTime() + "Double.MAX_EXPONENT = " + Double.MAX_EXPONENT);
//        2018-03-19 14:09:13:774  Double.MAX_VALUE = 1.7976931348623157E308
//        2018-03-19 14:09:13:775  Double.MIN_VALUE = 4.9E-324
//        2018-03-19 14:09:13:775  Double.MAX_EXPONENT = 1023

        System.out.println(MyUtils.getCurrentTime() + "Double.POSITIVE_INFINITY = " + Double.POSITIVE_INFINITY);
        System.out.println(MyUtils.getCurrentTime() + "Double.NEGATIVE_INFINITY = " + Double.NEGATIVE_INFINITY);
        System.out.println(MyUtils.getCurrentTime() + "Double.NaN = " + Double.NaN);
//        2018-03-19 14:10:43:858  Double.POSITIVE_INFINITY = Infinity
//        2018-03-19 14:10:43:858  Double.NEGATIVE_INFINITY = -Infinity
//        2018-03-19 14:10:43:858  Double.NaN = NaN

        System.out.println(MyUtils.getCurrentTime() + "( 2.0 - 1.1 ) = " + (2.0 - 1.1));
//        2018-03-19 14:13:15:598  ( 2.0 - 1.1 ) = 0.8999999999999999
//        float和double类型的数值在计算机中采用二进制表示,二进制无法精确地表示分数1/10(类似于十进制无法精确表达1/3或1/7)
//        遇到需要精确表达的计算,必须采用EffectiveJava相关章节的处理方式

        System.out.println(MyUtils.getCurrentTime() + "Character.BYTES = " + Character.BYTES);
//        2018-03-19 14:19:48:970  Character.BYTES = 2  当前系统中一个char类型变量占两个byte

        System.out.println(MyUtils.getCurrentTime() + "'\\u0000' = " + '\u0000');//char类型数据用字面量值表示
        System.out.println(MyUtils.getCurrentTime() + "'\\uffff' = " + '\uffff');
    }
}
