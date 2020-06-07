package com.yueyang.datastruct.recursion;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-10 11:26
 **/
public class RecursionTest {


    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } else {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        test(5);

        System.out.println(factorial(4));
    }


    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;

    }
}