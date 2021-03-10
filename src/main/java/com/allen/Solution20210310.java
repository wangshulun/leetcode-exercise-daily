package com.allen;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3  * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangshulun
 * @date 2021/3/10
 */
public class Solution20210310 {

    public static void main(String[] args) {

        String s = "1+2-(2+2)";
        int res = calculate(s);
        System.out.println("结果" + res);
    }

    public static int calculate(String s) {


        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);

        int sign = 1;
        int ret = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '+') {
                sign = ops.peek();
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
            } else if (s.charAt(i) == ')') {
                ops.pop();
            } else if (Character.isDigit(s.charAt(i))) {
                int num = sign * (s.charAt(i) - '0');
                System.out.println(num);
                ret += num;
            }

        }
        return ret;

    }

}
