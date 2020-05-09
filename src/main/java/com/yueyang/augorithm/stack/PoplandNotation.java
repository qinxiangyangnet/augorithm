package com.yueyang.augorithm.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class PoplandNotation {

    public static void main(String[] args) {
        String expression = "3 4 + 5 * 6 -";
        String expression1 = "3 4 + 5 * 6 -";

        List<String> listString = getListString(expression);
        int calculate = calculate(listString);

        System.out.println(calculate);
    }

    /**
     * 将逆波兰表达式 一次将数据和运算符放入集合中
     */

    public static List<String> getListString(String expression) {
        String[] s = expression.split(" ");
        List<String> stringList = new ArrayList<String>();
        for (String ele : s) {
            stringList.add(ele);
        }

        return stringList;
    }

    /**
     * 遍历集合计算
     *
     * @param ls
     * @return
     */
    public static int calculate(List<String> ls) {
        Stack<String> stacks = new Stack<String>();
        for (String item : ls) {
            //这里使用正则取出数
            if (item.matches("\\d+")) {
                //直接入栈
                stacks.push(item);
            } else {
                int num1 = Integer.parseInt(stacks.pop());
                int num2 = Integer.parseInt(stacks.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符问题");
                }
                stacks.push(res + "");
            }
        }
        return Integer.parseInt(stacks.pop());
    }
}
