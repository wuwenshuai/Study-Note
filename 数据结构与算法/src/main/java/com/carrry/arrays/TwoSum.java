package com.carrry.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] input = {2,7,11,15};
        StringBuilder sb = new StringBuilder("[");
        int[] ints = twoSumHash2(input, 9);
        sb.append(ints[0]).append(",").append( ints[1]);
        sb.append("]");
        System.out.println(sb.toString());

    }

    public static int[] twoSum (int [] nums, int target) {
        int n =nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int []{i,j};
                }
            }
        }
        return new int []{};
    }


    /**
     * 方法二：hash表的方法
     */
    public static int[] twoSumHash (int [] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组，把数据的value作为kye，索引作为value

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }

        //遍历数组
        for (int i = 0; i < n; i++){
            int data = target - nums[i];
            //map里面有值，并且不是当前这个索引  [3,2,4]  6
            //利用空间（用map存）换时间
            if (map.containsKey(data) && map.get(data) != i) {
                return new int []{i,map.get(data)};
            }
        }
        return new int []{};
    }


    /**
     * 改进：遍历一次hash表
     */


    public static int[] twoSumHash2 (int [] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组，把数据的value作为kye，索引作为value
        int n = nums.length;
        //遍历数组
        for (int i = 0; i < n; i++){
            int data = target - nums[i];
            if (map.containsKey(data) && map.get(data) != i) {
                return new int []{map.get(data),i};
            }
            map.put(nums[i],i);
        }
        return new int []{};
    }

}
