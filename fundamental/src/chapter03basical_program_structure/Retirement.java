package chapter03basical_program_structure;

import java.util.Scanner;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/22 12:13
 */
public class Retirement {
    public static void main(String[] args) {
        Scanner vScanner = new Scanner(System.in);
        System.out.println("How much money do you need to retire?");
        double goal = vScanner.nextDouble();
        System.out.println("How much money will you contribute every year?");
        double payment = vScanner.nextDouble();
        System.out.println("interest rate in %:");
        double interestRate = vScanner.nextDouble();
        double balance = 0;
        int year = 0;
        while (balance < goal) {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
        }
        System.out.println("You can retire in " + year + " years.");
    }
}
//        How much money do you need to retire?
//        600000
//        How much money will you contribute every year?
//        25000
//        interest rate in %:
//        6
//        You can retire in 15 years.
//
//        Process finished with exit code 0
