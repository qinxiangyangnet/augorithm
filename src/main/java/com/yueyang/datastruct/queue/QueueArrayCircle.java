package com.yueyang.datastruct.queue;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-07 07:20
 **/
public class QueueArrayCircle {

    private int front;
    private int rear;
    private int maxSize;

    private int[] arr;

    public QueueArrayCircle(int maxSize) {
        this.maxSize = maxSize;
        rear = 0;
        front = 0;
        arr = new int[maxSize];
    }


    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;

        //将rear后移,必须考虑大于maxSize情况，即最后一位的时候，
        rear = (rear + 1) % maxSize;

    }

    public int getQueue() {
        //取出数据
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }

        //分析front指向对列的第一个元素
        //1，front值保存到一个临时变量，
        //2,将front后移，考虑取模
        //3,返回

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据-----");
        }

        //从front遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }


    }


    /**
     * 当前队列的有效数据
     */

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示头元素
     */

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据-----");
        }
        return arr[front];
    }

}