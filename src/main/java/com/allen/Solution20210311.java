package com.allen;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * @author wangshulun
 * @date 2021/3/11
 */
public class Solution20210311 {

    public static void main(String[] args) {
        String s = "1+2 *3 /2";

        System.out.println(calculate(s));
    }


    public static int calculate(String s) {

        Deque<Integer> stack = new LinkedList<Integer>();

        int num = 0;
        int len = s.length();
        char preSign = '+';

        for (int i = 0; i < len; i++) {

            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                preSign = s.charAt(i);
            }

            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (preSign == '/') {
                    stack.push(stack.pop() / num);
                }
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }


        return res;
    }

}
