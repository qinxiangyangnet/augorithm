package com.yueyang.augorithm.search;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-17 18:20
 **/
public class FibSearch {

    private static final int MAXSIZE = 20;

    public int[] fib() {
        int[] fib = new int[MAXSIZE];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < MAXSIZE; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }


    public int fibSearch(int[] arr, int key) {
        int[] fib = fib();

        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        while (high > fib[k] - 1)
            k++;

        int[] temp = Arrays.copyOf(arr, fib[k]);


        for (int i = high + 1; i < temp.length; i++)
            temp[i] = arr[high];


        //使用while循环找到key
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                /**
                 * 1，全部元素=前面的元素+后面的元素
                 * 2，f[k]=f[k-1]+f[k-2]
                 * 3,因为前面有f[k-1]个元素，所以继续拆分f[k-1]=f[k-2]+f[k-3]
                 * 4,在f[k-1]继续查找，所以k--
                 */
                k--;
            } else if (key > temp[mid]) {
                low = mid++;
                /**
                 * 1，全部元素=前面的元素+后面的元素
                 * 2，f[k]=f[k-1]+f[k-2]
                 * 3,因为后面有f[k-2]个元素，所以继续拆分f[k-2]=f[k-3]+f[k-4]
                 * 4,在f[k-1]继续查找，所以k--
                 */
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;

    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = fibSearch(arr, 1);
        System.out.println(i);
    }
}