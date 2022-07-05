package com.carrry.string;

/**
 * #415
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 思路：可以对两个数的每一位相加，位数低的需要补0，得到的结果对10取余，就是某一位的结果，除以十就是要不要进一  (最大的肯呢个就是9+9)
 */
public class AddStrings {


    public static void main(String[] args) {
        System.out.println(addString("123", "123"));
    }


    public static String addString(String num1,String num2) {


        StringBuilder result = new StringBuilder();
        int i= num1.length()-1;
        int j= num2.length()-1;
        //当前进位
        int current = 0;
        //从个位开始，逐个遍历,然后想加，没有的补零
        while (i >= 0 || j>=0 || current !=0) {
            //获取当前的两个字符
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            //对当前数求和
            int sum = n1 + n2 +current;
            //把结果保存起来
            result.append(sum % 10);
            current = sum /10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
