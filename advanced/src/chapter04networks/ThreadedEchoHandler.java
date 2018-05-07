package chapter04networks;

import utils.MyUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/7 20:53
 * Project:CoreJava
 */
public class ThreadedEchoHandler implements Runnable {

    private final Socket mSocket;

    public ThreadedEchoHandler(Socket socket) {
        mSocket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(mSocket.getInputStream(), "UTF-8");
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(mSocket.getOutputStream(), "UTF-8"), true);
            printWriter.println("Hello!Print BYE to exit!");
            boolean done = false;
            while (!done && scanner.hasNextLine()){
                printWriter.println(MyUtils.getCurrentTime() + "scanner.hasNextLine() = " + scanner.hasNextLine());
                String line = scanner.nextLine();
                printWriter.println(MyUtils.getCurrentTime() + "Echo : " + line);
                if (line.trim().equalsIgnoreCase("bye")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
