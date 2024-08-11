package com.carrry.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {10,8,9,7,6,5,9,3,2,1};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {


        for (int i = 1; i < arr.length; i++) {  // 0 ~ i 做到有序

            for (int j = i -1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr,j,j+1);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
