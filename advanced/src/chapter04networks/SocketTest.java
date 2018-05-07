package chapter04networks;

import utils.MyUtils;

import java.io.IOException;
import java.net.*;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/7 19:15
 * Project:CoreJava
 */
public class SocketTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");//www.baidu.com/183.232.231.172
            System.out.println(MyUtils.getCurrentTime() + "inetAddress = " + inetAddress);
            System.out.println(MyUtils.getCurrentTime() + "inetAddress.isReachable(1000) = " + inetAddress.isReachable(3000));
            System.out.println(MyUtils.getCurrentTime() + "inetAddress.getHostAddress() = " + inetAddress.getHostAddress());
            System.out.println(MyUtils.getCurrentTime() + "inetAddress.getHostName() = " + inetAddress.getHostName());
            System.out.println(MyUtils.getCurrentTime() + "inetAddress.getCanonicalHostName() = " + inetAddress.getCanonicalHostName());
//                    2018-05-07 19:26:31:851  inetAddress = www.baidu.com/183.232.231.172
//                    2018-05-07 19:26:31:913  inetAddress.isReachable(1000) = false
//                    2018-05-07 19:26:34:918  inetAddress.getHostAddress() = 183.232.231.172
//                    2018-05-07 19:26:34:919  inetAddress.getHostName() = www.baidu.com
//                    2018-05-07 19:26:34:919  inetAddress.getCanonicalHostName() = 183.232.231.172

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket = null;
        try {
            socket = new Socket("183.232.231.172", 80);
            System.out.println(MyUtils.getCurrentTime() + "socket = " + socket);
            System.out.println(MyUtils.getCurrentTime() + "socket.isConnected() = " + socket.isConnected());
            System.out.println(MyUtils.getCurrentTime() + "socket.getChannel() = " + socket.getChannel());
            System.out.println(MyUtils.getCurrentTime() + "socket.getInetAddress() = " + socket.getInetAddress());
//            2018-05-07 19:26:34:988  socket = Socket[addr=/183.232.231.172,port=80,localport=65265]
//            2018-05-07 19:26:34:989  socket.isConnected() = true
//            2018-05-07 19:26:34:989  socket.getChannel() = null
//            2018-05-07 19:26:34:990  socket.getInetAddress() = /183.232.231.172
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
