package chapter03basical_program_structure;

import com.sun.xml.internal.ws.util.StringUtils;
import utils.MyUtils;

import java.util.Arrays;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/19 17:36
 */
public class StringTest {
    public static void main(String[] args) {
        String vS = "Java\u2122";
        System.out.println(MyUtils.getCurrentTime() + "vS = " + vS);//vS = Java™
        String vSubstring = vS.substring(0, 3);
        System.out.println(MyUtils.getCurrentTime() + "vSubstring = " + vSubstring);//vSubstring = Jav
        String vSubstring1 = vS.substring(3);
        System.out.println(MyUtils.getCurrentTime() + "vSubstring1 = " + vSubstring1);//vSubstring1 = a™

        /* 字符串拼接 */
        String vExpletive = "Expletive";
        String vDeleted = "deleted";
        String message = vExpletive + vDeleted;
        System.out.println(MyUtils.getCurrentTime() + "message = " + message);//message = Expletivedeleted

        /* 多个字符串拼接使用String.join方法 @since 1.8 */
        System.out.println(MyUtils.getCurrentTime() +
                "String.join(\" / \",\"S\",\"M\",\"L\",\"XL\") = " +
                String.join(" / ", "S", "M", "L", "XL"));//String.join(" / ","S","M","L","XL") = S / M / L / XL

        /* 字符串常量的指针位置共享 */
        String greeting = "Hello";
        String vHello = "Hello";
        System.out.println(MyUtils.getCurrentTime() + "(greeting == vHello) = " + (greeting == vHello));//(greeting == vHello) = true
        String vConcat = "Hel" + "lo";
        System.out.println(MyUtils.getCurrentTime() + "(greeting == vConcat) = " + (greeting == vConcat));//(greeting == vConcat) = true
        String vConcat1 = "Hel".concat("lo");
        System.out.println(MyUtils.getCurrentTime() + "(greeting == vConcat1) = " + (greeting == vConcat1));//(greeting == vConcat1) = false

        /* 码点codePoint */
        System.out.println(MyUtils.getCurrentTime() + "greeting.length() = " + greeting.length());//5
        System.out.println(MyUtils.getCurrentTime() + "greeting.codePointCount(0,greeting.length()) = " + greeting.codePointCount(0, greeting.length()));//5
        String string = "山河表里潼关路宫阙万间都做了土";
        System.out.println(MyUtils.getCurrentTime() + "string.length() = " + string.length());//15
        System.out.println(MyUtils.getCurrentTime() + "string.codePointCount(0,string.length()) = " + string.codePointCount(0, string.length()));//15
        System.out.println(MyUtils.getCurrentTime() +
                "Arrays.toString(string.codePoints().toArray()) = " +
                Arrays.toString(string.codePoints().toArray()));//[23665, 27827, 34920, 37324, 28540, 20851, 36335, 23467, 38425, 19975, 38388, 37117, 20570, 20102, 22303]
        System.out.println(MyUtils.getCurrentTime() + "Integer.toHexString(23665) = " + Integer.toHexString(23665));//5c71
        System.out.println(MyUtils.getCurrentTime() + "'\\u5c71' = " + '\u5c71');// '\u5c71' = 山

        System.out.println(MyUtils.getCurrentTime() +
                "new String(string.codePoints().toArray(),0,7) = " +
                new String(string.codePoints().toArray(), 0, 7));//new String(string.codePoints(),0,7).toArray() = 山河表里潼关路

        System.out.println(MyUtils.getCurrentTime() + "string.charAt(6) = " + string.charAt(6));        //string.charAt(6) = 路
        System.out.println(MyUtils.getCurrentTime() + "string.charAt(6) = " + (int) string.charAt(6));   //string.charAt(6) = 36335

    }
}
