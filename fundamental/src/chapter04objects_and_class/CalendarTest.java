package chapter04objects_and_class;

import utils.MyUtils;

import java.time.LocalDate;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/22 16:08
 */
public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(MyUtils.getCurrentTime() + "date = " + date);
        int vMonthValue = date.getMonthValue();
        int vDayOfMonth = date.getDayOfMonth();
        date = date.minusDays(1);
        System.out.println(MyUtils.getCurrentTime() + "date = " + date);
    }
}
