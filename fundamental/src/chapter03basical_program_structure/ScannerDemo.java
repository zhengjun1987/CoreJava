package chapter03basical_program_structure;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/22 9:37
 */
public class ScannerDemo {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Paths.get("C:\\Users\\Lenovo\\IdeaProjects\\CoreJava\\CoreJava.iml"), "UTF-8");
        PrintWriter out = new PrintWriter("myfile.txt","UTF-8");
        while (in.hasNextLine()) {
            String vLine = in.nextLine();
            out.print(vLine);
            out.print('\n');
            System.out.println(vLine);
        }
        in.close();
        out.close();
    }
}
