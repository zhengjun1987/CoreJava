package chapter0602lambda;

import java.util.logging.Logger;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/23 16:15
 */
public class Greeter {
    public void greet(String pX){
        System.out.println(pX);
        Logger.getGlobal().fine("File -> "+pX);
    }
}
