package chapter02javaio;

import sun.nio.cs.StreamDecoder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/15 16:35
 */
public class NeoStreamDecoder {
    private StreamDecoder mStreamDecoder;

    /**
     * 由于StreamDecoder类的构造器全部都属于package-private的
     * 所以无法直接继承StreamDecoder类
     *
     * @author Zheng Jun
     */
    NeoStreamDecoder(InputStream a,Object b,CharsetDecoder c) {
        mStreamDecoder = StreamDecoder.forInputStreamReader(a,b,c);
    }
}
