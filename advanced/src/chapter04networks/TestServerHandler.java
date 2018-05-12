package chapter04networks;

import utils.MyUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/11 20:53
 * Project:CoreJava
 */
public class TestServerHandler implements Runnable {

    private final Socket mSocket;
    private final InterruptibleSocketFrame mInterruptibleSocketFrame;
    private int counter;

    public TestServerHandler(InterruptibleSocketFrame interruptibleSocketFrame, Socket socket) {
        System.out.println(MyUtils.getCurrentTime() + "TestServerHandler.TestServerHandler  " + "interruptibleSocketFrame = [" + interruptibleSocketFrame + "], socket = [" + socket + "]");
        mSocket = socket;
        mInterruptibleSocketFrame = interruptibleSocketFrame;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = mSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            while (counter < 100) {
                counter++;
                if (counter <= 10) {
                    printWriter.println(counter);
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            mInterruptibleSocketFrame.mMessages.append("\nTestServerHandler.run: " + e);
        } finally {
            try {
                mSocket.close();
                mInterruptibleSocketFrame.mMessages.append("Closing server...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
