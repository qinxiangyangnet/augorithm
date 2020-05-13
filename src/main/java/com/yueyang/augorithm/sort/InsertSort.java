package com.yueyang.augorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: augorithm
 * @description: 插入排序
 *
 * @author: qinxiangyang
 * @create: 2020-05-13 07:30
 **/
public class InsertSort {

    public void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            //insertIndex>0 保证在给insertValue找插入位置不越界
            //insertValue < arr[insertIndex]  待插入的数还没有找到插入的位置

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //将arr[insertIndex]后移，让出来
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;

            }

            arr[insertIndex + 1] = insertValue;
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

        insertSort(arr2);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        System.out.println(Arrays.toString(arr));

    }
}