package chapter02javaio;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/18 16:59
 */
public class Employee {
    static final int NAME_SIZE = 30;//字符数
    static final long RECORD_SIZE = NAME_SIZE * 2 + 4 * 4;//字节数
    private String name;
    private int salary;
    private int birth_year;
    private int birth_month;
    private int birth_day;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birth_year=" + birth_year +
                ", birth_month=" + birth_month +
                ", birth_day=" + birth_day +
                '}';
    }

    Employee(String pName, int pSalary, int pBirth_year, int pBirth_month, int pBirth_day) {
        name = pName;
        salary = pSalary;
        birth_year = pBirth_year;
        birth_month = pBirth_month;
        birth_day = pBirth_day;
    }

    String getName() {
        return name;
    }

    int getSalary() {
        return salary;
    }

    int getBirth_year() {
        return birth_year;
    }

    int getBirth_month() {
        return birth_month;
    }

    int getBirth_day() {
        return birth_day;
    }
}
