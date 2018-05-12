package chapter04networks;

import utils.MyUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/12 21:16
 * Project:CoreJava
 */
public class URLEncoderTest {
    public static void main(String[] args) {
        try {
            String encode = URLEncoder.encode("San Francisco, CA", "UTF-8");//San+Francisco%2C+CA
            System.out.println(MyUtils.getCurrentTime() + "URLEncoder.encode(\"San Francisco, CA\") = " + URLEncoder.encode("San Francisco, CA"));
            System.out.println(MyUtils.getCurrentTime() + "URLEncoder.encode(\"可怜九月初三夜，露似真珠月似弓\") = " + URLEncoder.encode("可怜九月初三夜，露似真珠月似弓"));
            System.out.println(MyUtils.getCurrentTime() + "encode = " + encode);


            System.out.println(MyUtils.getCurrentTime() + "URLDecoder.decode(\"%E5%8F%AF%E6%80%9C%E4%B9%9D%E6%9C%88%E5%88%9D%E4%B8%89%E5%A4%9C%EF%BC%8C%E9%9C%B2%E4%BC%BC%E7%9C%9F%E7%8F%A0%E6%9C%88%E4%BC%BC%E5%BC%93\") = " + URLDecoder.decode("%E5%8F%AF%E6%80%9C%E4%B9%9D%E6%9C%88%E5%88%9D%E4%B8%89%E5%A4%9C%EF%BC%8C%E9%9C%B2%E4%BC%BC%E7%9C%9F%E7%8F%A0%E6%9C%88%E4%BC%BC%E5%BC%93","UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String encodedString = "%E5%8F%AF%E6%80%9C%E4%B9%9D%E6%9C%88%E5%88%9D%E4%B8%89%E5%A4%9C%EF%BC%8C%E9%9C%B2%E4%BC%BC%E7%9C%9F%E7%8F%A0%E6%9C%88%E4%BC%BC%E5%BC%93";
        System.out.println(MyUtils.getCurrentTime() + "encodedString.length() = " + encodedString.length());
        System.out.println(MyUtils.getCurrentTime() + "(135/15) = " + (135 / 15));
    }
}
//        2018-05-12 21:19:28:900  URLEncoder.encode("San Francisco, CA") = San+Francisco%2C+CA
//        2018-05-12 21:19:28:959  URLEncoder.encode("可怜九月初三夜，露似真珠月似弓") = %E5%8F%AF%E6%80%9C%E4%B9%9D%E6%9C%88%E5%88%9D%E4%B8%89%E5%A4%9C%EF%BC%8C%E9%9C%B2%E4%BC%BC%E7%9C%9F%E7%8F%A0%E6%9C%88%E4%BC%BC%E5%BC%93
//        2018-05-12 21:19:28:959  encode = San+Francisco%2C+CA

