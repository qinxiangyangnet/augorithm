package com.yueyang.tenaugorithm.dynamic;

/**
 * @program: augorithm
 * @description: 背包问题
 * @author: qinxiangyang
 * @create: 2020-06-04 06:33
 **/
public class KnapsackProblem {


    public static void main(String[] args) {
        int[] val = {1500, 3000, 2000};
        int[] w = {1, 4, 3};
        int n = 4;//背包的最大容量
        int m = w.length;//个数
        int[][] v = new int[m + 1][n + 1];

        //为了记录商品放入的情况定义一个二维数组
        int[][] path = new int[m + 1][n + 1];
        //初始化第一行为0；
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //初始化第一列为0；
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        //动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                //从第二行第二列开始
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // v[i][j] = Math.max(v[i - 1][j], val[i-1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放背包的情况，不能简单的使用公式，需要使用if...else替代
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }

                }
            }
        }


        //遍历查看
        for (int i = 0; i < v.length; i++) {

            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //遍历查看
        for (int i = 0; i < path.length; i++) {

            for (int j = 0; j < path[0].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }

        //输出我们最后放的那些商品,逆向遍历
        int i=path.length-1;
        int j=path[0].length-1;
        while(i>0&&j>0){
            if(path[i][j]==1){
                System.out.printf("第%d个商品放入到背包中\n",i);
                j -=w[i-1];
            }
            i--;
        }


    }
}