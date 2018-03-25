package chapter03basical_program_structure;

import java.util.Scanner;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/22 15:06
 */
public class LotteryOdds {
    public static void main(String[] args) {
        Scanner vScanner = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw?");
        int k = vScanner.nextInt();
        System.out.println("What's the highest number you can draw?");
        int n = vScanner.nextInt();
        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds * (n-i+1)/i;
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}
//        How many numbers do you need to draw?
//        2
//        What's the highest number you can draw?
//        490
//        Your odds are 1 in 119805. Good luck!
//
//        Process finished with exit code 0
