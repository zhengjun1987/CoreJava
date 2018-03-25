package chapter0602lambda;

import utils.MyUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/23 11:41
 */
public class Worker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(MyUtils.getCurrentTime() + "Worker.actionPerformed  " + "e = [" + e + "]");
    }
}
