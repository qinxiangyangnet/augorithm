package com.yueyang.augorithm.heap;

import java.util.Arrays;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-23 12:34
 **/
public class Test {

    @org.junit.Test
    public void test() {
        int[] arr = {4, 9, 5, 7, 6, -1, -2, 33};
        HeapSort.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}