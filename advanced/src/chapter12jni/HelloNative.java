package chapter12jni;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/7 23:57
 * Project:CoreJava
 */
public class HelloNative {
    static {
        System.out.println( System.getProperty("java.library.path"));
        System.load("/Users/zhengjun/IdeaProjects/CoreJava/advanced/src/libgreeting.so");
    }

    public static void main(String[] args) {
        greeting();
        print(5,2,3.141592654);
    }

    public static native void greeting();
    public static native int print(int width,int precision,double x);
}
//        /Users/zhengjun/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
//        Hello,Jni! 3.14
//        Process finished with exit code 0