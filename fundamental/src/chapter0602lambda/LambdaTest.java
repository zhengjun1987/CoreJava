package chapter0602lambda;

import utils.ExecutionDurationTimer;
import utils.MyUtils;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/23 14:32
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] vStrings = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(vStrings));
        System.out.println("Sort in dictionary order:");
        Arrays.sort(vStrings,LambdaSth::test);
        System.out.println(Arrays.toString(vStrings));
        System.out.println("Sort by length:");
        Arrays.sort(vStrings, (a, b) -> b.length() - a.length());
        System.out.println(Arrays.toString(vStrings));
//        [Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune]
//        Sort in dictionary order:
//        [Earth, Jupiter, Mars, Mercury, Neptune, Saturn, Uranus, Venus]
//        Sort by length:
//        [Mars, Earth, Venus, Saturn, Uranus, Jupiter, Mercury, Neptune]

        ExecutionDurationTimer vExecutionDurationTimer = new ExecutionDurationTimer();
        long vExecute = vExecutionDurationTimer.execute(10, () -> System.out.println(MyUtils.getCurrentTime() + "LambdaTest.main  " + "args = [" + new Date() + "]"));
        System.out.println(MyUtils.getCurrentTime() + "vExecute = " + vExecute);
//        2018-03-23 14:46:26:899  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:930  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:930  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:930  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:930  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:930  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:930  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:930  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:931  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:931  LambdaTest.main  args = [Fri Mar 23 14:46:26 CST 2018]
//        2018-03-23 14:46:26:931  vExecute = 32299722
    }
}
