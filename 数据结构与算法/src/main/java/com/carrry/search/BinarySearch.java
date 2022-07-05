package com.carrry.search;

/**
 * @author cw3k
 * @version 1.0
 * @description: 二分查找，又叫折半查找，建立在有序的集合基础上，先要找到元素的中间值mid，
 * 然后拿它和要找的元素进行比较，如果比这个数大，就再另外一半查找
 * 时间复杂度：: log2(N)
 * @date 2022/7/5 17:42
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(search(nums, 4));
    }
    public static int search(int nums[], int target){
        int n = nums.length;
        // 定义左右指针
        int left = 0;
        int right = n-1;

        if (target <nums[left] || target > nums[right]) {
            return -1;
        }
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] < target) {
                // 说明比中间值要大，需要 从mid后面进行折半
                left = mid +1;
            }else if (nums[mid] > target) {
                // 说明比中间值小，需要 从 left 到 mid-1 找
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
