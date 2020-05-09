package com.yueyang.augorithm.stack;

/**
 * @program: augorithm
 * @description:综合计算器的实现
 * @author: qinxiangyang
 * @create: 2020-05-09 20:59
 **/
public class Calculator {
    public static void main(String[] args) {

        String expression = "3+2*6-2";

        //创建两个栈
        StackArray numberStack = new StackArray(10);
        StackArray operStack = new StackArray(10);

        //定义需要的相关变量
        int  

    }

    // -------------------------------------功能扩展--------------------------------------------------


    /**
     * 返回运算符的优先级，程序员决定
     * 优先级使用数字表示，数字越大，优先级越高
     */


    public int priority(int oper) {

        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            //目前表达4只有=-*/

            return -1;
        }


    }

    /**
     * 判断是不是运算符
     *
     * @param val
     * @return
     */
    public boolean isOper(char val) {

        return val == '+' || val == '-' || val == '*' || val == '/';

    }

    /**
     * 计算方法
     */

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;

        }

        return res;
    }

}