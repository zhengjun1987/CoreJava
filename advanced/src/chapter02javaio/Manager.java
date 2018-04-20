package chapter02javaio;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/4/20 10:28
 */
public class Manager extends Employee {
    private Employee secretary;

    Employee getSecretary() {
        return secretary;
    }

    void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    Manager(String pName, int pSalary, int pBirth_year, int pBirth_month, int pBirth_day) {
        super(pName, pSalary, pBirth_year, pBirth_month, pBirth_day);
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                " secretary=" + secretary +
                '}';
    }
}
