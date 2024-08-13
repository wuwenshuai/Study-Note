package com.carrry.异或;


/**
 * 	// arr中，只有一种数，出现奇数次
 * 	找出这个数
 */
public class EvenTimesOddTimes {

    public static void main(String[] args) {
        int num[] = {1,1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 13,14, 14, 15, 15, 16, 16};
        // printOddTimesNum1(num);

        printOddTimesNum2(num);

    }


    public static void printOddTimesNum1(int[] arr) {

        // 只有一种数出现了奇数次，其他出现了偶数次，就拿一个变量去挨个和数组的值进行，异或，根据异或的特性，两个相同的数异或为0，0和任何数异或都为任何数
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
    }


    // 题目升级一下：	// arr中，有两种数，出现奇数次，求这两个数

    public static void printOddTimesNum2(int[] arr) {

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        // 找到er最右一位是1的
        int rightOne = eor & (-eor);

        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne = onlyOne ^ arr[i];
            }
        }

        System.out.println(onlyOne);
        System.out.println(eor^onlyOne);
    }
}
