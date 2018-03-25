package chapter03basical_program_structure;

import java.io.Console;
import java.util.Arrays;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/21 16:26
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Console vConsole = System.console();
        if (vConsole != null) {
            String name = vConsole.readLine("User name:");
            char[] vPassword = vConsole.readPassword("Password:");
            System.out.println("name = " + name+" Password:"+ Arrays.toString(vPassword));
        } else {
            System.out.println("vConsole = " + vConsole);
        }
    }
}
