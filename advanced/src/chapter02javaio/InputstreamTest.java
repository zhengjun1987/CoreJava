package chapter02javaio;

import utils.MyUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/15 16:01
 */
public class InputstreamTest {
    public static void main(String[] args) {
//        new InputStream(){
//            @Override
//            public int read(byte[] b) throws IOException {
//                return super.read(b);
//            }
//
//            @Override
//            public int read(byte[] b, int off, int len) throws IOException {
//                return super.read(b, off, len);
//            }
//
//            @Override
//            public long skip(long n) throws IOException {
//                return super.skip(n);
//            }
//
//            @Override
//            public int available() throws IOException {
//                return super.available();
//            }
//
//            @Override
//            public void close() throws IOException {
//                super.close();
//            }
//
//            @Override
//            public synchronized void mark(int readlimit) {
//                super.mark(readlimit);
//            }
//
//            @Override
//            public synchronized void reset() throws IOException {
//                super.reset();
//            }
//
//            @Override
//            public boolean markSupported() {
//                return super.markSupported();
//            }
//
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//        };
        System.out.println(MyUtils.getCurrentTime() + "Byte.MAX_VALUE = " + (int)Byte.MAX_VALUE);
        System.out.println(MyUtils.getCurrentTime() + "Short.MAX_VALUE = " + (int)Short.MAX_VALUE);
        System.out.println(MyUtils.getCurrentTime() + "Character.MAX_VALUE = " + (int)Character.MAX_VALUE);
    }
}
