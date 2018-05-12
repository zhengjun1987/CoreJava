package chapter04networks;

import javax.swing.*;
import java.awt.*;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/10 21:06
 * Project:CoreJava
 */
public class InterruptibleSocket {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jFrame = new InterruptibleSocketFrame();
            jFrame.setTitle("InterruptibleSocket");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
    }
}
