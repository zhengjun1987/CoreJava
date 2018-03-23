package chapter03basical_program_structure;

        import utils.MyUtils;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/19 16:22
 */
public class MathAPIs {
    public static void main(String[] args) {
        System.out.println(MyUtils.getCurrentTime() + "Math.sqrt(625) = " + Math.sqrt(625));
        System.out.println(MyUtils.getCurrentTime() + "Math.pow(625,0.5) = " + Math.pow(625, 0.5));
        System.out.println(MyUtils.getCurrentTime() + "Math.floorMod(11,12) = " + Math.floorMod(11, 12));
//        2018-03-19 16:28:57:947  Math.sqrt(625) = 25.0
//        2018-03-19 16:28:57:993  Math.pow(625,0.5) = 25.0
//        2018-03-19 16:28:57:993  Math.floorMod(11,12) = 11

        System.out.println(MyUtils.getCurrentTime() + "Math.cos(Math.PI/3) = " + Math.cos(Math.PI / 3));
//        2018-03-19 16:30:21:666  Math.cos(Math.PI/3) = 0.5000000000000001
        System.out.println(MyUtils.getCurrentTime() + "Math.log(Math.E) = " + Math.log(Math.E));
//        2018-03-19 16:31:24:307  Math.log(Math.E) = 1.0
    }
}
