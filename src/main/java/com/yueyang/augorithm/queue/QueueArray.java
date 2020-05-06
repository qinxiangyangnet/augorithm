package com.yueyang.augorithm.queue;

import java.util.Arrays;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-06 19:20
 **/
public class QueueArray {
    /**
     * 表示容器的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 对列卫
     */
    private int rear;
    /**
     * 该数据用来存储数据
     */
    private int[] arr;

    //创建队列的构造器
    public QueueArray(int maxSize) {
        maxSize = this.maxSize;
        //初始化数组
        arr = new int[maxSize];
        //指向队列头的前一个位置
        front = -1;
        //指向队列尾
        rear = -1;

    }

    /**
     * 判断队列是否满
     */

    public Boolean isFull() {
        return rear == maxSize;
    }

    /**
     * 判断是否为空
     */

    public Boolean isEmpty() {
        return front == rear;
    }


    /**
     * 添加队列
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加数据");
            return;
        }

        rear++;//rear后移

        arr[rear] = n;

    }

    /**
     * 获取数据
     */

    public int getQueue() {
        //取出数据
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }

        front++;
        return arr[front];
    }

    /**
     * 展示队里的所有的数据
     */

    public void showList() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据-----");
        }
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 显示队列的头数剧
     */

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据-----");
        }
        return arr[front + 1];
    }


}