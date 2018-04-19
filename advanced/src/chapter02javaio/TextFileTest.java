package chapter02javaio;

import utils.MyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/18 16:58
 */
public class TextFileTest {

    public static final String EMPLOYEE_DAT = "employee.dat";
    public static final String UTF_8 = "utf-8";

    public static void main(String[] args) {
        Employee[] vEmployees = new Employee[3];
        vEmployees[0] = new Employee("Carl Cracker",75000,1987,12,15);
        vEmployees[1] = new Employee("Harry Hacker",50000,1989,10,1);
        vEmployees[2] = new Employee("Tony Tester",40000,1990,3,15);
        try {
            PrintWriter vPrintWriter = new PrintWriter(EMPLOYEE_DAT);
            writeData(vEmployees,vPrintWriter);
            vPrintWriter.flush();
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        }


        try {
            Scanner vScanner = new Scanner(new FileInputStream(EMPLOYEE_DAT));
            Employee[] readData = readData(vScanner);
            System.out.println(MyUtils.getCurrentTime() + "Arrays.toString(readData) = " + Arrays.toString(readData));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Employee[] readData(Scanner pScanner) {
        System.out.println(MyUtils.getCurrentTime() + "TextFileTest.readData  " + "pScanner = [" + pScanner + "]");
        int i = Integer.parseInt(pScanner.nextLine());
        System.out.println(MyUtils.getCurrentTime() + "i = " + i);
        Employee[] employees = new Employee[i];
        for (int k = 0; k < i; k++) {
            employees[k] = resolveEmployee(pScanner);
        }
        return employees;
    }

    private static Employee resolveEmployee(Scanner scanner) {
        String nextLine = scanner.nextLine();
        String[] strings = nextLine.split("\\|");
        System.out.println(MyUtils.getCurrentTime() + "Arrays.toString(strings) = " + Arrays.toString(strings));
        String[] date = strings[2].split("-");
        System.out.println(MyUtils.getCurrentTime() + "Arrays.toString(date) = " + Arrays.toString(date));
        return new Employee(strings[0],Integer.valueOf(strings[1]),Integer.valueOf(date[0]),Integer.valueOf(date[1]),Integer.valueOf(date[2]));
    }

    private static void writeData(Employee[] pEmployees, PrintWriter pPrintWriter) {
        System.out.println(MyUtils.getCurrentTime() + "pEmployees.length = " + pEmployees.length);
        pPrintWriter.println(pEmployees.length);
        for (Employee pEmployee : pEmployees) {
            System.out.println(MyUtils.getCurrentTime() + "pEmployee = " + pEmployee);
            writeEmployee(pEmployee,pPrintWriter);
        }
    }

    private static void writeEmployee(Employee pEmployee, PrintWriter pPrintWriter) {
        pPrintWriter.println(pEmployee.getName()+"|"+pEmployee.getSalary()+"|"+pEmployee.getBirth_year()+"-"+pEmployee.getBirth_month()+"-"+pEmployee.getBirth_day());
    }
}
//        2018-04-19 13:37:42:463  pEmployees.length = 3
//        2018-04-19 13:37:42:479  pEmployee = Employee{name='Carl Cracker', salary=75000, birth_year=1987, birth_month=12, birth_day=15}
//        2018-04-19 13:37:42:479  pEmployee = Employee{name='Harry Hacker', salary=50000, birth_year=1989, birth_month=10, birth_day=1}
//        2018-04-19 13:37:42:479  pEmployee = Employee{name='Tony Tester', salary=40000, birth_year=1990, birth_month=3, birth_day=15}
//        2018-04-19 13:37:42:479  TextFileTest.readData  pScanner = [java.util.Scanner[delimiters=\p{javaWhitespace}+][position=0][match valid=false][need input=false][source closed=false][skipped=false][group separator=\,][decimal separator=\.][positive prefix=][negative prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\Q�\E][infinity string=\Q∞\E]]
//        2018-04-19 13:37:42:479  i = 3
//        2018-04-19 13:37:42:479  Arrays.toString(strings) = [Carl Cracker, 75000, 1987-12-15]
//        2018-04-19 13:37:42:479  Arrays.toString(date) = [1987, 12, 15]
//        2018-04-19 13:37:42:479  Arrays.toString(strings) = [Harry Hacker, 50000, 1989-10-1]
//        2018-04-19 13:37:42:479  Arrays.toString(date) = [1989, 10, 1]
//        2018-04-19 13:37:42:479  Arrays.toString(strings) = [Tony Tester, 40000, 1990-3-15]
//        2018-04-19 13:37:42:479  Arrays.toString(date) = [1990, 3, 15]
//        2018-04-19 13:37:42:479  Arrays.toString(readData) = [Employee{name='Carl Cracker', salary=75000, birth_year=1987, birth_month=12, birth_day=15}, Employee{name='Harry Hacker', salary=50000, birth_year=1989, birth_month=10, birth_day=1}, Employee{name='Tony Tester', salary=40000, birth_year=1990, birth_month=3, birth_day=15}]
//
//        Process finished with exit code 0
