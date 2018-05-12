package chapter04networks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/11 20:48
 * Project:CoreJava
 */
public class TestServer implements Runnable {

    private final InterruptibleSocketFrame mInterruptibleSocketFrame;
    private ExecutorService mExecutorService;

    public TestServer(InterruptibleSocketFrame interruptibleSocketFrame) {
        mInterruptibleSocketFrame = interruptibleSocketFrame;
    }

    @Override
    public void run() {
        try {
            mExecutorService = Executors.newCachedThreadPool();
            ServerSocket serverSocket = new ServerSocket(8189);
            Socket socket = serverSocket.accept();
            mExecutorService.execute(new TestServerHandler(mInterruptibleSocketFrame,socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
