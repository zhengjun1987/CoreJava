package chapter0602lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: Zheng Jun
 * Mail:zhengjun1987@outlook.com
 * Date: 2018/3/23 11:43
 */
public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() == o2.length()
                ? o1.compareTo(o2)
                : o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String[] vStrings = {"常记溪亭日暮", "兴尽晚回舟", "只恐双溪舴艋舟", "争渡"};
        Arrays.sort(vStrings, new LengthComparator());
        System.out.println(Arrays.toString(vStrings));// [争渡, 兴尽晚回舟, 常记溪亭日暮, 只恐双溪舴艋舟]
        vStrings = new String[]{"常记溪亭日暮", "兴尽晚回舟", "只恐双溪舴艋舟", "争渡"};
        Arrays.sort(vStrings, (first, second) -> second.length() - first.length());
        System.out.println(Arrays.toString(vStrings));// [只恐双溪舴艋舟, 常记溪亭日暮, 兴尽晚回舟, 争渡]
    }
}
