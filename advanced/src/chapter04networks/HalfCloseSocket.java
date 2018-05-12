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
 * Date:2018/5/7 21:38
 * Project:Algorithms4thEdition
 */
public class HalfCloseSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8189);
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            printWriter.println("白日依山尽\n黄河入海流\n欲穷千里目\n更上一层楼");
            socket.shutdownOutput();
            System.out.println(MyUtils.getCurrentTime() + "socket.isOutputShutdown() = " + socket.isOutputShutdown());
            while (scanner.hasNextLine()) {
                System.out.println(MyUtils.getCurrentTime() + "scanner.nextLine() = " + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//        2018-05-07 21:43:47:470  scanner.nextLine() = Hello!Print BYE to exit!
//        2018-05-07 21:43:47:472  scanner.nextLine() = 2018-05-07 21:43:47:446  scanner.hasNextLine() = true
//        2018-05-07 21:43:47:473  scanner.nextLine() = 2018-05-07 21:43:47:447  Echo : 白日依山尽
//        2018-05-07 21:43:47:474  scanner.nextLine() = 2018-05-07 21:43:47:447  scanner.hasNextLine() = true
//        2018-05-07 21:43:47:474  scanner.nextLine() = 2018-05-07 21:43:47:447  Echo : 黄河入海流
//        2018-05-07 21:43:47:475  scanner.nextLine() = 2018-05-07 21:43:47:447  scanner.hasNextLine() = true
//        2018-05-07 21:43:47:475  scanner.nextLine() = 2018-05-07 21:43:47:447  Echo : 欲穷千里目
//        2018-05-07 21:43:47:476  scanner.nextLine() = 2018-05-07 21:43:47:448  scanner.hasNextLine() = true
//        2018-05-07 21:43:47:482  scanner.nextLine() = 2018-05-07 21:43:47:448  Echo : 更上一层楼
