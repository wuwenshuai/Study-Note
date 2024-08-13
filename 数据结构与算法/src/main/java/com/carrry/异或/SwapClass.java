package com.carrry.异或;

import java.util.Arrays;


/**
 * 不引入第三个变量的情况下，交换两个数值
 */
public class SwapClass {


    public static void main(String[] args) {
        int num[] = {1,2,3,4,5,6,7,8,9};
        swap(num,1,2);
        System.out.println(Arrays.toString(num));
    }


    public static void swap(int num[] ,int a, int b)
    {
        num[a] = num[a] ^ num[b];
        num[b] = num[a] ^ num[b];
        num[a] = num[a] ^ num[b];
    }
}
