package chapter01javase8streams;

import utils.MyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/15 10:25
 */
public class ReadAllBytes {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("CoreJava.iml")), StandardCharsets.UTF_8);
        List<String> vStrings = Arrays.asList(contents.split("\\PL+"));
        long count = 0;
        for (String vString : vStrings) {
            if (vString.length()<5) {
                count++;
            }
        }
        System.out.println(MyUtils.getCurrentTime() + "count = " + count);

        long vCount = vStrings.stream().filter(w -> w.length() < 5).count();
        System.out.println(MyUtils.getCurrentTime() + "vCount = " + vCount);
    }
}
//        2018-03-15 11:27:36:705  count = 12
//        2018-03-15 11:27:36:758  vCount = 12
