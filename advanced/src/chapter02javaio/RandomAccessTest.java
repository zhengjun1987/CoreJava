package chapter02javaio;

import utils.MyUtils;

import java.io.*;
import java.util.Arrays;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/19 16:02
 */
public class RandomAccessTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        employees[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        employees[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(TextFileTest.EMPLOYEE_DAT));
            for (Employee employee : employees) {
                writeData(dataOutputStream, employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(TextFileTest.EMPLOYEE_DAT, "r");
            System.out.println(MyUtils.getCurrentTime() + "randomAccessFile = " + randomAccessFile.length());
            long size = randomAccessFile.length() / Employee.RECORD_SIZE;
            System.out.println(MyUtils.getCurrentTime() + "size = " + size);
            Employee[] readData = new Employee[(int) size];
            for (int i = 0; i < size; i++) {
                readData[i] = readEmployee(randomAccessFile, i);
            }
            System.out.println(MyUtils.getCurrentTime() + "Arrays.toString(readData) = " + Arrays.toString(readData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employee readEmployee(RandomAccessFile raf, int i) throws IOException {
        raf.seek(i * Employee.RECORD_SIZE);
        return new Employee(DataIO.readFixedLengthString(raf, Employee.NAME_SIZE), raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt());
    }

    private static void writeData(DataOutputStream dataOutputStream, Employee employee) throws IOException {
        System.out.println(MyUtils.getCurrentTime() + "写入数据 = " + employee);
        DataIO.writeFixedLengthString(employee.getName(), Employee.NAME_SIZE, dataOutputStream);
        dataOutputStream.writeInt(employee.getSalary());
        dataOutputStream.writeInt(employee.getBirth_year());
        dataOutputStream.writeInt(employee.getBirth_month());
        dataOutputStream.writeInt(employee.getBirth_day());
    }
}
//        2018-04-19 17:21:20:713  写入数据 = Employee{name='Carl Cracker', salary=75000, birth_year=1987, birth_month=12, birth_day=15}
//        2018-04-19 17:21:20:739  写入数据 = Employee{name='Harry Hacker', salary=50000, birth_year=1989, birth_month=10, birth_day=1}
//        2018-04-19 17:21:20:740  写入数据 = Employee{name='Tony Tester', salary=40000, birth_year=1990, birth_month=3, birth_day=15}
//        2018-04-19 17:21:20:742  randomAccessFile = 228
//        2018-04-19 17:21:20:742  size = 3
//        2018-04-19 17:21:20:742  readFixedLengthString返回 = Carl Cracker
//        2018-04-19 17:21:20:742  readFixedLengthString返回 = Harry Hacker
//        2018-04-19 17:21:20:743  readFixedLengthString返回 = Tony Tester
//        2018-04-19 17:21:20:743  Arrays.toString(readData) = [Employee{name='Carl Cracker', salary=75000, birth_year=1987, birth_month=12, birth_day=15}, Employee{name='Harry Hacker', salary=50000, birth_year=1989, birth_month=10, birth_day=1}, Employee{name='Tony Tester', salary=40000, birth_year=1990, birth_month=3, birth_day=15}]
