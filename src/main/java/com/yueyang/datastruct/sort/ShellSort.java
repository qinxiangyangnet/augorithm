package com.yueyang.datastruct.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: augorithm
 * @description: 希尔排序
 * @author: qinxiangyang
 * @create: 2020-05-13 10:00
 **/
public class ShellSort {


    /**
     * 交换法排序
     *
     * @param arr
     */
    public void shellSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        int temp = 0;
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                    //  System.out.println(j+":::"+gap);
                }

                //System.err.println("---------------------------");

            }

        }


    }


    /**
     * 移位法排序
     *
     * @param arr
     */
    public void shellSort1(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int index = i;
                int insertValue = arr[index];

                if (arr[index] < arr[index - gap]) {
                    while (index - gap >= 0 && insertValue < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = insertValue;
                }
            }
        }
    }


    @Test
    public void test() {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, 11, 23, 45, 56};

        //测试数据，给8万个数据，创建一个随机的数组
        int[] arr2 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }

        long begin = System.currentTimeMillis();

        shellSort1(arr);
        long end = System.currentTimeMillis();
      //  System.out.println(end - begin);
        System.out.println(Arrays.toString(arr));

    }
}