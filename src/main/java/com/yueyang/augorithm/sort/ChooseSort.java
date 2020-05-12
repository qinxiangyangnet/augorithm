package com.yueyang.augorithm.sort;

import org.junit.Test;

/**
 * @program: augorithm
 * @description: 选择排序
 *
 * 时间比冒泡快
 * 只进行一次交换，最后的那次
 * @author: qinxiangyang
 * @create: 2020-05-13 07:04
 **/
public class ChooseSort {


    public void chooseSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            //从遍历处进行初始化
            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //如果下标不一致，说明需要交换
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }


        }

    }

    @Test
    public void test() {
        int[] arr = {78, 42, 22, 8, 199, 65, 3, 9, -1};

        //测试数据，给8万个数据，创建一个随机的数组
        int[] arr2 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }

        long begin = System.currentTimeMillis();

        chooseSort(arr2);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

    }
}