package com.carrry.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int arr[] = {1, 5, 3, 2, 4};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {


        if (arr == null || arr.length < 2) {
            return;
        }

        //arr[0～N-1]范围上，找到最小值所在的位置，然后把最小值交换到0位置。
        //arr[1～N-1]范围上，找到最小值所在的位置，然后把最小值交换到1位置。
        //arr[2～N-1]范围上，找到最小值所在的位置，然后把最小值交换到2位置
        //…arr[N-1～N-1]范围上，找到最小值位置，然后把最小值交换到N-1位置。

        for (int i = 0; i < arr.length - 1; i++) {   // i --  n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length - 1; j++) {  // i---n-1找到最小值的下标
                if (arr[j] < arr[minIndex]) {
                    // 做替换
                    swap(arr, i, j);
                }
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

