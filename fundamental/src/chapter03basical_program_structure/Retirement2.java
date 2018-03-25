package chapter03basical_program_structure;

import java.util.Scanner;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/22 14:39
 */
public class Retirement2 {
    public static void main(String[] args) {
        Scanner vScanner = new Scanner(System.in);
        System.out.println("How much money will you contribute every year?");
        double payment = vScanner.nextDouble();
        System.out.println("Interest rate in %:");
        double interestRate = vScanner.nextDouble();

        double balance = 0;
        int year = 0;
        String input;

        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
            System.out.printf("After year %d, your balance is %,.2f%n", year, balance);
            System.out.println("Ready to retire? (Y/N)");
            input = vScanner.next();
        } while (input.equalsIgnoreCase("N"));
    }
}
//    How much money will you contribute every year?
//        80000
//        Interest rate in %:
//        4
//        After year 1, your balance is 83,200.00
//        Ready to retire? (Y/N)
//
//        N
//        After year 2, your balance is 169,728.00
//        Ready to retire? (Y/N)
//        N
//        After year 3, your balance is 259,717.12
//        Ready to retire? (Y/N)
//        N
//        After year 4, your balance is 353,305.80
//        Ready to retire? (Y/N)
//        N
//        After year 5, your balance is 450,638.04
//        Ready to retire? (Y/N)
//        N
//        After year 6, your balance is 551,863.56
//        Ready to retire? (Y/N)
//        N
//        After year 7, your balance is 657,138.10
//        Ready to retire? (Y/N)
//        N
//        After year 8, your balance is 766,623.62
//        Ready to retire? (Y/N)
//        N
//        After year 9, your balance is 880,488.57
//        Ready to retire? (Y/N)
//        N
//        After year 10, your balance is 998,908.11
//        Ready to retire? (Y/N)
//        N
//        After year 11, your balance is 1,122,064.44
//        Ready to retire? (Y/N)
//        N
//        After year 12, your balance is 1,250,147.01
//        Ready to retire? (Y/N)
//        N
//        After year 13, your balance is 1,383,352.90
//        Ready to retire? (Y/N)
//        N
//        After year 14, your balance is 1,521,887.01
//        Ready to retire? (Y/N)
//        N
//        After year 15, your balance is 1,665,962.49
//        Ready to retire? (Y/N)
//        N
//        After year 16, your balance is 1,815,800.99
//        Ready to retire? (Y/N)
//        N
//        After year 17, your balance is 1,971,633.03
//        Ready to retire? (Y/N)
//        N
//        After year 18, your balance is 2,133,698.35
//        Ready to retire? (Y/N)
//        Y

