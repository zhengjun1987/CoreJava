package chapter02javaio;

import java.io.*;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/9 14:56
 */
public class DataInputStreamTest {
    public static void main(String[] args) throws IOException {
        BufferedInputStream vIn;
        DataInputStream vDataInputStream = new DataInputStream(vIn = new BufferedInputStream(new FileInputStream("myfile.txt")));
        byte ch;
        try {
            while ((ch = vDataInputStream.readByte()) != 0) {
                System.out.print(String.valueOf((char) ch));
            }

        } catch (EOFException pEOFException) {
            System.out.println("\nEnd Of File!");
        } finally {

        }
    }
}
//    <?xml version="1.0" encoding="UTF-8"?>
//<module type="WEB_MODULE" version="4">
//<component name="NewModuleRootManager" inherit-compiler-output="true">
//<exclude-output />
//<content url="file://$MODULE_DIR$" />
//<orderEntry type="inheritedJdk" />
//<orderEntry type="sourceFolder" forTests="false" />
//</component>
//</module>
//
//        End Of File!
//
//        Process finished with exit code 0
