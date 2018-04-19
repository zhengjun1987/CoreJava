package chapter02javaio;

import utils.MyUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/19 16:25
 */
public class DataIO {
    static void writeFixedLengthString(String text, int size, DataOutputStream dataOutputStream) throws IOException {
        for (int i = 0; i < size; i++) {
            char ch = 0;
            if (i < text.length())
                ch = text.charAt(i);
            dataOutputStream.writeChar(ch);
        }
    }

    static String readFixedLengthString(RandomAccessFile randomAccessFile, int size) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(size);
        int j = 0;
//        boolean hasMore = true;
//        while (hasMore && j < size) {
//            char c = randomAccessFile.readChar();
//            j++;
//            if (c == 0) {
//                hasMore = false;
//            } else {
//                stringBuilder.append(c);
//            }
//        }


        for (int i = 0; i < size ; i++) {
            char read = randomAccessFile.readChar();
            if (read != 0) {
                stringBuilder.append(read);
            }
        }
        String string = stringBuilder.toString();
        System.out.println(MyUtils.getCurrentTime() + "readFixedLengthString返回 = " + string);
        return string;
    }
}
