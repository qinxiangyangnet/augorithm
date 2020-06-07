package com.yueyang.datastruct.recursion;

/**
 * @program: augorithm
 * @description:迷宫
 * @author: qinxiangyang
 * @create: 2020-05-10 12:29
 **/
public class MiGong {


    public static void main(String[] args) {
        int[][] arrays = new int[8][7];
        init(arrays);
        list(arrays);

        setWay(arrays, 1, 1);

        System.out.println("走过的路。。。");
        list(arrays);
    }

    /**
     * 设置路径
     *
     * @param arrays
     * @param i
     * @param
     */
    private static Boolean setWay(int[][] arrays, int i, int j) {
        if (arrays[6][5] == 2) {
            return true;
        } else {
            if (arrays[i][j] == 0) {
                arrays[i][j] = 2;
                if (setWay(arrays, i + 1, j)) {
                    return true;
                } else if (setWay(arrays, i, j + 1)) {
                    return true;
                } else if (setWay(arrays, i - 1, j)) {
                    return true;
                } else if (setWay(arrays, i, j - 1)) {
                    return true;
                } else {
                    arrays[i][j] = 3;
                    return false;
                }

            } else {
                return false;
            }
        }

    }

    /**
     * 初始化数组
     *
     * @param arrays
     */
    private static void init(int[][] arrays) {

        //所有初始化为0
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                arrays[i][j] = 0;
            }
        }

        //上下置为1
        for (int i = 0; i < 7; i++) {
            arrays[0][i] = 1;
            arrays[7][i] = 1;
        }

        //左右置为1
        for (int i = 0; i < 8; i++) {

            arrays[i][0] = 1;
            arrays[i][6] = 1;
        }

        //设置隔板
        arrays[3][1] = 1;
        arrays[3][2] = 1;


    }


    /**
     * 数组列表
     *
     * @param arrays
     */
    public static void list(int[][] arrays) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(arrays[i][j] + "  ");
            }
            System.out.println();
        }

    }


}