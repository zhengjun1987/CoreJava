package chapter02javaio;

import utils.MyUtils;

import java.io.*;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/20 10:28
 */
public class ObjectStreamTest {

    public static final String STAFF_DAT = "staff.dat";

    public static void main(String[] args) {
        Manager carl_cracker = new Manager("Carl Cracker", 75000, 1987, 12, 15);
        Manager harry_hacker = new Manager("Harry Hacker", 50000, 1989, 10, 1);
        Employee tony_tester = new Employee("Tony Tester", 40000, 1990, 3, 15);

        carl_cracker.setSecretary(tony_tester);
        harry_hacker.setSecretary(tony_tester);
        Employee[] employees = new Employee[3];
        employees[0] = carl_cracker;
        employees[1] = harry_hacker;
        employees[2] = tony_tester;

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(STAFF_DAT));
            outputStream.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(STAFF_DAT));
            Employee[] readObject = (Employee[]) inputStream.readObject();
            for (Employee employee : readObject) {
                System.out.println(MyUtils.getCurrentTime() + "employee = " + employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
//        2018-04-20 10:46:24:697  employee = Manager{Employee{name='Carl Cracker', salary=75000, birth_year=1987, birth_month=12, birth_day=15} secretary=Employee{name='Tony Tester', salary=40000, birth_year=1990, birth_month=3, birth_day=15}}
//        2018-04-20 10:46:24:713  employee = Manager{Employee{name='Harry Hacker', salary=50000, birth_year=1989, birth_month=10, birth_day=1} secretary=Employee{name='Tony Tester', salary=40000, birth_year=1990, birth_month=3, birth_day=15}}
//        2018-04-20 10:46:24:713  employee = Employee{name='Tony Tester', salary=40000, birth_year=1990, birth_month=3, birth_day=15}
