package chapter02javaenv;

import utils.MyUtils;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/3/18 02:07
 * Project:CoreJava
 */
public class Welcome {
    public static void main(String[] args) {
        String greetings = "Welcome to Core Java";
        String x = "greetings = " + greetings;
        System.out.println(x);
        for (int i = 0; i < x.length(); i++) {
            System.out.print("=");
        }
    }
}
//        2018-03-18 12:13:45:524  greetings = Welcome to Core Java
//        =========================================================
//        Process finished with exit code 0

