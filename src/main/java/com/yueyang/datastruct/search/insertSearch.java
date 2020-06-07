package com.yueyang.datastruct.search;

import org.junit.Test;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-17 18:07
 **/
public class insertSearch {

    public int insertSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        if (findValue > arr[mid]) {
            insertSearch(arr, mid + 1, right, findValue);
        } else if (findValue < arr[mid]) {
            insertSearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = insertSearch(arr, 0, arr.length - 1, 5);
        System.out.println(i);
    }
}