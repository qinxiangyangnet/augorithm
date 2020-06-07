package com.yueyang.datastruct.tree;

/**
 * @program: augorithm
 * @description: 顺序存储二叉树
 * @author: qinxiangyang
 * @create: 2020-05-22 21:18
 **/
public class ArrayBinaryTree {

    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 前序遍历
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法遍历。。。。。");
            return;
        }
        System.out.println(arr[index]);

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 中遍历
     */
    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法遍历。。。。。");
            return;
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            midOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            midOrder(index * 2 + 2);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法遍历。。。。。");
            return;
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }
}