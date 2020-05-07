package com.yueyang.augorithm.queue;

import java.util.Scanner;

/**
 * @program: augorithm
 * @description: 数组演示队列
 * @author: qinxiangyang
 * @create: 2020-05-06 19:18
 **/
public class QueueArrayDemo {

    public static void main(String[] args) {


        QueueArray queueArray = new QueueArray(3);

        queueArrayTest(queueArray);
    }

    private static void queueArrayTest(QueueArray queueArray) {
        char key = ' ';
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("s(show)： 显示队列");
            System.out.println("e(exit)： 退出程序");
            System.out.println("a(add)： 添加数据");
            System.out.println("g(get)： 从队列取出数据");
            System.out.println("h(head)： 查看队列头数据");

            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    queueArray.showList();
                    break;
                case 'a':
                    System.out.println("输入一个数据");
                    int i = scanner.nextInt();
                    queueArray.addQueue(i);
                    break;
                case 'g':
                    try {

                        int queue = queueArray.getQueue();
                        System.out.println("取出数据是：" + queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {

                        int queue = queueArray.headQueue();
                        System.out.println("队列头的头数据：" + queue);
                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;

            }

        }
        System.out.println("程序退出。。。。。。。。。。");
    }
}