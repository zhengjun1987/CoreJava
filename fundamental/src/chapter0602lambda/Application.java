package chapter0602lambda;

import utils.MyUtils;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/26 10:21
 */
public class Application {
    private String location;
    private Thread mThread;

    Application(String pLocation) {
        location = pLocation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Application{");
        sb.append("location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }

    protected void start(){
        mThread = new Thread(() -> {
            System.out.println(MyUtils.getCurrentTime() +this.toString());
        });
        mThread.start();
    }

    public static void main(String[] args) {
        new Application("浙江省杭州市滨江区滨盛路2099号").start();
        System.out.println(MyUtils.getCurrentTime() + "String.format(\"%.2f\",7/100) = " + String.format("%3.2f", -1.0 / 100));
    }
}
//2018-03-26 10:26:19:017  Application{location='浙江省杭州市滨江区滨盛路2099号'}
