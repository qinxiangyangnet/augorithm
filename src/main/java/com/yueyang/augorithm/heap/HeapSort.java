package com.yueyang.augorithm.heap;

/**
 * @program: augorithm
 * @description: 堆排序
 * <p>
 * 怎么把
 * @author: qinxiangyang
 * @create: 2020-05-23 11:21
 **/
public class HeapSort {

    public static void heapSort(int arr[]) {
        //        System.out.println("第一次----------");
//        HeapSort.adjustHeap(arr, 1, arr.length);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("第二次----------");
//        HeapSort.adjustHeap(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            HeapSort.adjustHeap(arr, i, arr.length);
        }

        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            HeapSort.adjustHeap(arr, 0, j);
        }
    }


    /**
     * 将一个数组，调整成一个大顶堆
     * <p>
     * <p>
     * 完成以i为子节点的大顶堆的调整
     * int arr[]={4,6,8,5,9}  =>  i=1  arr.length/2-1 adjustHeap  ==>  {4,9,8,5,6}
     * i=arr  adjustHeap  ==>  {9,6,8,5,4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素调整，length在逐渐建雄安
     */
    public static void adjustHeap(int arr[], int i, int length) {

        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {

            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;

            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}