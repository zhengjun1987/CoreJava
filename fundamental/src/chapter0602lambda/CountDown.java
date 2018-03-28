package chapter0602lambda;

import utils.MyUtils;

import java.awt.event.ActionListener;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/26 9:36
 */
public class CountDown {
    public static void countdown(int start,int delay) {
        ActionListener vActionListener = e -> {
//            start--;//Variable used in lambda expression should be final or effectively final
            System.out.println(MyUtils.getCurrentTime() +start);
        };
    }
}
