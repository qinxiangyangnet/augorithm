package com.yueyang.augorithm.recursion;

/**
 * @program: augorithm
 * @description: 8皇后
 * @author: qinxiangyang
 * @create: 2020-05-10 14:46
 **/
public class Queen8 {


    public static int maxSize = 8;
    static int[] queens = new int[maxSize];

    static int count = 0;

    public static void main(String[] args) {
        check(0);

        System.out.println("一共有：" + count + " 解法");
    }

    public static void check(int n) {
        if (n == 8) {
            //表示前面8个皇后已经完成
            //打印

            print();
            count++;
            System.out.println();
            return;
        }

        for (int i = 0; i < maxSize; i++) {
            //先把第一个皇后放在第一列
            queens[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
            //说明不满足规则继续向下递归
        }


    }

    /**
     * 判断是否冲突
     *
     * @param n
     * @return
     */
    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //queens[i] == queens[n] 表示在同一列
            //Math.abs(i - n) == Math.abs(queens[n] - queens[i])  表示在同一个斜线上
            if (queens[i] == queens[n] || Math.abs(i - n) == Math.abs(queens[n] - queens[i])) {
                return false;
            }
        }
        return true;

    }


    public static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.print(queens[i] + " ");
        }
    }
}