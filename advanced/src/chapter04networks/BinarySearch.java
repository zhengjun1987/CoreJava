package chapter04networks;

import utils.MyUtils;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/9 20:24
 * Project:CoreJava
 */
public class BinarySearch {
    // This is Arrays.binarySearch(), but doesn't do any argument validation.
    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int i = binarySearch(arr, 3, 4);
        System.out.println(MyUtils.getCurrentTime() + "binarySearch(arr,3,4) = " + i);
        System.out.println(MyUtils.getCurrentTime() + "~i = " + ~i);
        System.out.println(MyUtils.getCurrentTime() + "binarySearch(arr,3,1) = " + binarySearch(arr, 3, 1));
        System.out.println(MyUtils.getCurrentTime() + "binarySearch(arr,3,-1) = " + binarySearch(arr, 3, -1));
        System.out.println(MyUtils.getCurrentTime() + "binarySearch(arr,3,0) = " + binarySearch(arr, 3, 0));
    }
}
