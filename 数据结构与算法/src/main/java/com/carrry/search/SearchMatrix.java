package com.carrry.search;


/**
 * #74
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 *
 * 思路解析：在一个m*n的矩阵中，对于一个(row,col)的元素，展开后的有序数字的规则：idx = row * n +col
 * 对于一维下标为idx的元素，对应二维数组中的坐标应该是 row = idx/n   col = idx % n;
 */
public class SearchMatrix {


    public static boolean searchMatrix (int[][] matrix, int target) {

        return false;

    }
}
