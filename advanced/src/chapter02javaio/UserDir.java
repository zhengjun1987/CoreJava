package chapter02javaio;

import utils.MyUtils;

import java.io.File;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/9 14:36
 */
public class UserDir {
    public static void main(String[] args) {
        System.out.println(MyUtils.getCurrentTime() + "System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
//        2018-04-09 14:37:48:305  System.getProperty("user.dir") = C:\Users\Lenovo\IdeaProjects\CoreJava

        /* 文件 */
        File vFile = new File("myfile.txt");
        System.out.println(MyUtils.getCurrentTime() + "vFile.getAbsolutePath() = " + vFile.getAbsolutePath());
//        2018-04-09 14:42:48:282  vFile.getAbsolutePath() = C:\Users\Lenovo\IdeaProjects\CoreJava\myfile.txt


        /* 子目录 */
        File vAdvanced = new File("advanced");
        System.out.println(MyUtils.getCurrentTime() + "vAdvanced.getAbsolutePath() = " + vAdvanced.getAbsolutePath());
//        2018-04-09 14:40:41:324  vAdvanced.getAbsolutePath() = C:\Users\Lenovo\IdeaProjects\CoreJava\advanced

        /* 子目录文件 */
        File vFile1 = new File(".idea/misc.xml");
        System.out.println(MyUtils.getCurrentTime() + "vFile1.getAbsolutePath() = " + vFile1.getAbsolutePath());
//        2018-04-09 14:44:56:318  vFile1.getAbsolutePath() = C:\Users\Lenovo\IdeaProjects\CoreJava\.idea\misc.xml

        /* 子目录文件 */
        File vFile2 = new File("/.idea/misc.xml");
        System.out.println(MyUtils.getCurrentTime() + "vFile2.getAbsolutePath() = " + vFile2.getAbsolutePath());
//        2018-04-09 14:44:56:318  vFile1.getAbsolutePath() = C:\.idea\misc.xml --> 单斜杠代表着根目录

        File vFile3 = new File("/");
        System.out.println(MyUtils.getCurrentTime() + "vFile3.getAbsolutePath() = " + vFile3.getAbsolutePath());
//        2018-04-09 14:47:08:366  vFile3.getAbsolutePath() = C:\ --> 单斜杠代表着根目录

        File vFile4 = new File("\\");
        System.out.println(MyUtils.getCurrentTime() + "vFile4.getAbsolutePath() = " + vFile4.getAbsolutePath());
//        2018-04-09 14:48:40:354  vFile4.getAbsolutePath() = C:\ --> 反斜杠也代表着根目录

        File vFile5 = new File(".idea\\");
        System.out.println(MyUtils.getCurrentTime() + "vFile5.getAbsolutePath() = " + vFile5.getAbsolutePath());
//        2018-04-09 14:50:25:858  vFile5.getAbsolutePath() = C:\Users\Lenovo\IdeaProjects\CoreJava\.idea --> 路径名后的斜杠无意义

        File vFile6 = new File(".idea/");
        System.out.println(MyUtils.getCurrentTime() + "vFile6.getAbsolutePath() = " + vFile6.getAbsolutePath());
//        2018-04-09 14:50:25:858  vFile6.getAbsolutePath() = C:\Users\Lenovo\IdeaProjects\CoreJava\.idea --> 路径名后的斜杠无意义

        File vFile7 = new File(".idea\\misc.xml");
        System.out.println(MyUtils.getCurrentTime() + "vFile7.getAbsolutePath() = " + vFile7.getAbsolutePath());
//        2018-04-09 14:53:05:758  vFile7.getAbsolutePath() = C:\Users\Lenovo\IdeaProjects\CoreJava\.idea\misc.xml --> "\\"与"/"意义完全一样

    }
}
