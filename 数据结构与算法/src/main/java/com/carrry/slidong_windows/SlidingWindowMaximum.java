package com.carrry.slidong_windows;


import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * #239
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *  
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例1:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println();
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        //使用双向队列实现
        int[] result = new int[nums.length - k +1];
        // 定义双向队列
        ArrayQueue<Object> deque = new ArrayQueue<>(1);
        return result;
    }
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        // 暴力法，遍历每个滑动窗口，找到每个窗口的最大值
        int[] result = new int[nums.length - k +1];
        //遍历数组
        for (int i = 0; i < result.length-k; i++) {
            int max = nums[i];
            for (int j = i; j< i+k; j++) {
                if (nums[j]  > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }





}
