package chapter02javaio;

import utils.MyUtils;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/20 15:27
 */
public class SerialCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Manager carl_cracker = new Manager("Carl Cracker", 75000, 1987, 12, 15);
        Manager harry_hacker = new Manager("Harry Hacker", 50000, 1989, 10, 1);
        Employee tony_tester = new Employee("Tony Tester", 40000, 1990, 3, 15);

        carl_cracker.setSecretary(tony_tester);
        harry_hacker.setSecretary(tony_tester);

        Employee harry2 = harry_hacker.clone();
        System.out.println(MyUtils.getCurrentTime() + "(harry2 == harry_hacker) = " + (harry2 == harry_hacker));
        System.out.println(MyUtils.getCurrentTime() + "harry_hacker = " + harry_hacker);
        System.out.println(MyUtils.getCurrentTime() + "harry2 = " + harry2);
    }
}
