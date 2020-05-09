package com.yueyang.augorithm.stack;

import org.junit.Test;

/**
 * @program: augorithm
 * @description: 用数组模拟栈
 * @author: qinxiangyang
 * @create: 2020-05-09 20:17
 **/
public class StackArray {


    private int[] stackArray;//数组模拟栈

    private int top = -1;//栈顶

    private int maxSize;//栈大小

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
    }

    public StackArray() {
    }

    /**
     * 是否栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }


    /**
     * 是否栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * 入栈
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，请先取出数据，再存");
            return;
        }
        top++;
        stackArray[top] = value;
    }


    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，请存入数据再取");
        }
        int value = stackArray[top];
        top--;
        return value;
    }

    /**
     * 栈遍历
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("无数据");
            return;
        }

        for (int i = 0; i < top; i++) {
            System.out.println(stackArray[i]);
        }
    }



}