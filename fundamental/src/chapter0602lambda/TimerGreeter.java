package chapter0602lambda;

import utils.ExecutionDurationTimer;
import utils.MyUtils;

import java.util.logging.Logger;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/23 16:16
 */
public class TimerGreeter extends Greeter {
    @Override
    public void greet(String pX) {
        long vExecute = new ExecutionDurationTimer().execute(10, () -> super.greet(pX));
        System.out.println(MyUtils.getCurrentTime() + "vExecute = " + vExecute);
        Logger.getGlobal().info("File -> "+vExecute);
    }

    public static void main(String[] args) {
        new TimerGreeter().greet("Hello,World!");
    }
}
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        Hello,World!
//        2018-03-23 16:20:14:366  vExecute = 243529
