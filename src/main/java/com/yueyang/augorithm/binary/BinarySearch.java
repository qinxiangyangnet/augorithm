package com.yueyang.augorithm.binary;

/**
 * @program: augorithm
 * @description:二分查找算法
 * @author: qinxiangyang
 * @create: 2020-06-04 05:39
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,3, 8, 10, 11, 67, 100};
        int i = binarySearch(arr, 0);
        System.out.println("索引： "+i);

    }


    /**
     * 二分查找非递归实现
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            //继续查找
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                //向左查找
                right = mid - 1;
            } else {
                //向右查找
                left = mid + 1;
            }
        }
        return -1;

    }
}