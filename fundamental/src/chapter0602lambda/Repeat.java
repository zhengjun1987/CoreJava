package chapter0602lambda;

import utils.ExecutionDurationTimer;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/23 16:43
 */
public class Repeat {
    public static void main(String[] args) {

    }

    public static void repeatMsg(String string,int delay){
        new ExecutionDurationTimer().execute(delay,() -> new Greeter().greet(string));
    }
}
