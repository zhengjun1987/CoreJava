package chapter04networks;

import utils.MyUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/7 20:48
 * Project:CoreJava
 */
public class ThreadedEchoServer {

    public static void main(String[] args) {
        ExecutorService sExecutorService = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            int i = 1;
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println(MyUtils.getCurrentTime() + "Spawning: " + i);
                Runnable runnable = new ThreadedEchoHandler(socket);
                sExecutorService.execute(runnable);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
