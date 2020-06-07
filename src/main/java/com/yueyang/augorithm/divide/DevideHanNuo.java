package com.yueyang.augorithm.divide;

/**
 * @program: augorithm
 * @description: 汉诺塔的实现
 * @author: qinxiangyang
 * @create: 2020-06-04 05:53
 **/
public class DevideHanNuo {
    public static void main(String[] args) {
      //  hanNuoTower(1,'A','B','C');
        hanNuoTower(5,'A','B','C');

    }


    public static void hanNuoTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第一个盘从 " + a + " > " + c);
        } else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的盘 2. 上面的盘
            //1,先把最上面a到b,借助c
            hanNuoTower(num - 1, a, c, b);
            //2，把最下边的盘a-c
            System.out.println("第" + num + "个盘从 " + a + " > " + c);
            //3，把b所有的盘移动到c
            hanNuoTower(num - 1, b, a, c);
        }

    }
}