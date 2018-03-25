package chapter04objects_and_class;

import java.time.LocalDate;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/22 16:08
 */
public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int vMonthValue = date.getMonthValue();
        int vDayOfMonth = date.getDayOfMonth();
        date = date.minusDays(vDayOfMonth - 1);
    }
}
