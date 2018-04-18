package chapter02javaio;

import utils.MyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
            PrintWriter vPrintWriter = new PrintWriter(EMPLOYEE_DAT, UTF_8);
            writeData(vEmployees,vPrintWriter);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (UnsupportedEncodingException pE) {
            pE.printStackTrace();
        }


        try {
            Scanner vScanner = new Scanner(new FileInputStream(EMPLOYEE_DAT), UTF_8);
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
        String[] strings = nextLine.split("|");
        String[] date = strings[2].split("-");
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
