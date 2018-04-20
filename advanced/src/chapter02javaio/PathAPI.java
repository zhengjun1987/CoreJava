package chapter02javaio;

import utils.MyUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/20 16:25
 */
public class PathAPI {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(MyUtils.getCurrentTime() + "property = " + property);//C:\Users\Lenovo\IdeaProjects\CoreJava
        Path path = Paths.get(property);
        System.out.println(MyUtils.getCurrentTime() + "path = " + path);//C:\Users\Lenovo\IdeaProjects\CoreJava

        Path advanced = Paths.get("advanced");
        System.out.println(MyUtils.getCurrentTime() + "advanced = " + advanced.getFileName());
    }
}
