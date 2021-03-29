package com.allen;

/**
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 * <p>
 * <p>
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * @author wangshulun
 * @date 2021/3/29
 */
public class Solution20210329 {

    public static void main(String[] args) {


        int i = 11;
        System.out.println(Integer.toBinaryString(i));
        int rev = reverseBits(i);
        System.out.println(Integer.toBinaryString(rev));
        System.out.println(rev);


    }


    public static int reverseBits(int n) {


        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            System.out.println("--------------------------------");
            rev |= (n & 1) << (31 - i);
            System.out.println(Integer.toBinaryString(rev));
            System.out.println(Integer.toBinaryString(n));
            n >>>= 1;
            System.out.println(Integer.toBinaryString(n));

        }
        return rev;

    }
}
