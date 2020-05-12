package com.yueyang.augorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-13 06:12
 **/
public class BubbleSort {


    /**
     * 第一版
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
                count++;
            }
            // System.out.println("第" + i + "次：：： " + count);

        }
    }


    /**
     * 优化
     */
    public void bubbleSort1(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        int temp = 0;
        boolean flag = false;
        for (int i = arr.length - 1; i > 0; i--) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
                count++;
            }
            //System.out.println("第" + i + "次：：： " + count);

            //表示一次都没有交换，说明已经是排序的状态，没必要进行循环排序了
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }


    @Test
    public void test() {

        int[] arr = {78, 42, 22, 8, 199, 65, 3, 9, -1};
        int[] arr1 = {1, 2, 34, 56};

        //测试数据，给8万个数据，创建一个随机的数组
        int[] arr2 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }
        // System.out.println(Arrays.toString(arr2));

        long begin = System.currentTimeMillis();

        bubbleSort1(arr2);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr2));
        System.out.println("花费时间：" + (end - begin));
    }
}