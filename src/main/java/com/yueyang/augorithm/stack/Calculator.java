package com.yueyang.augorithm.stack;

/**
 * @program: augorithm
 * @description:综合计算器的实现
 * @author: qinxiangyang
 * @create: 2020-05-09 20:59
 **/
public class Calculator {
    public static void main(String[] args) {

        String expression = "30+2*6-2*5";

        //创建两个栈
        StackArray numberStack = new StackArray(10);
        StackArray operStack = new StackArray(10);

        //定义需要的相关变量
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        int ch = ' ';//将每次扫描得到的char保存到ch
        String str = "";

        //遍历表达式
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOper(c)) {
                if (!operStack.isEmpty()) {
                    //不为空
                    if (priority(c) <= priority(operStack.peak())) {
                        //优先级
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = operStack.pop();
                        res = cal(num1, num2, oper);
                        //并将结果放入数栈中
                        numberStack.push(res);
                    }
                    operStack.push(c);
                } else {
                    //为空直接入栈
                    operStack.push(c);
                }
            } else {
                //多位数的问题
                //numberStack.push(c - 48);
                //当处理多位数的时候，不能出现一个数就入栈，需要定义一个字符串用于拼接多位数
                str += c;
                //判断下一个字符是不是数字
                if (i == expression.length() - 1) {
                    numberStack.push(Integer.parseInt(str));
                } else {
                    if(isOper(expression.substring(i+1,i+2).charAt(0))){
                        numberStack.push(Integer.parseInt(str));
                        str="";
                    }

                }
            }
        }

//***************表达式遍历完毕**********************
        if (operStack.isEmpty()) {
            System.out.println(numberStack.pop());
        }

        while (!operStack.isEmpty()) {
            oper = operStack.pop();
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            res = cal(num1, num2, oper);
            numberStack.push(res);
        }

        System.out.println(numberStack.pop());

    }

    // -------------------------------------功能扩展--------------------------------------------------


    /**
     * 返回运算符的优先级，程序员决定
     * 优先级使用数字表示，数字越大，优先级越高
     */


    public static int priority(int oper) {

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
    public static boolean isOper(char val) {

        return val == '+' || val == '-' || val == '*' || val == '/';

    }

    /**
     * 计算方法
     */

    public static int cal(int num1, int num2, int oper) {
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