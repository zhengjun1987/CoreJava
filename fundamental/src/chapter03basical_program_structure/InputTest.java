package chapter03basical_program_structure;

import java.util.Scanner;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/21 16:07
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner vScanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = vScanner.nextLine();
        System.out.println("How old are you?");
        int age = vScanner.nextInt();
        System.out.println("Hello, " + name + ". Next year you will be " + (age + 1));
        System.out.printf("Hello, %s. Next year you will be %d.\n",name,age+1);
    }
}
//        What's your name?
//        Zheng Jun
//        How old are you?
//        31
//        Hello, Zheng Jun. Next year you will be 32
//        Hello, Zheng Jun. Next year you will be 32
//
//        Process finished with exit code 0
