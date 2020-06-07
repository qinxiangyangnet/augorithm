package com.yueyang.datastruct.sparseArray;

import org.junit.Test;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-26 20:06
 **/

public class SparseArray {


    public int[][] arraycompass(int[][] arr) {

        int effect = 0;
        for (int[] row : arr) {
            for (int data : row) {
                if (data != 0) {
                    effect++;
                }
            }
        }
        System.out.println(effect);
        //创建稀疏数组
        int spaseArray[][] = new int[effect + 1][3];
        int row = arr.length;
        int column = arr[0].length;
        spaseArray[0][0] = row;
        spaseArray[0][1] = column;
        spaseArray[0][2] = effect;
        int count = 0;
        //遍历二维数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    spaseArray[count][0] = i;
                    spaseArray[count][1] = j;
                    spaseArray[count][2] = arr[i][j];
                }
            }

        }
        //输出

        System.out.println("输出稀疏数组");
        for (int[] row1 : spaseArray) {
            for (int data : row1) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return null;

    }

    @Test
    public void testSparseArray() {
        int chessArr[][] = new int[5][4];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][3] = 2;
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        arraycompass(chessArr);
    }

}