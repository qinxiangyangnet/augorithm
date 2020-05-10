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
//        String expression = "3 4 + 5 * 6 -";
//        String expression1 = "3 4 + 5 * 6 -";
//
//        List<String> listString = getListString(expression);
//        int calculate = calculate(listString);
//
//        System.out.println(calculate);

        String expresson = "1+((2+3)*40)-5";
        List<String> strings = toInffixExpresion(expresson);
        System.out.println(strings.toString());

        List<String> parse = parseSuffix(strings);
        System.out.println(parse);
    }


    public static List<String> parseSuffix(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>();
        //存储中间结果的栈，没有必要用栈，因为再整个操作过程中没有没有弹栈操作，比较麻烦，直接使用集合
        // Stack<String>  s2=new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        for (String item : ls) {
            //如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号，一直弹,加入到s2
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //消掉了一个小括号
                s1.pop();
            } else {
                //处理操作符优先级的问题
                //item的优先级小于等于栈顶运算符优先级，s1栈顶的运算符弹出，加入到s2
                //问题缺失一个优先级高低的方法
                while (s1.size() != 0 && Operation.getValus(s1.peek()) >= Operation.getValus(item)) {
                    s2.add(s1.pop());
                }
                //当前的item压入栈中
                s1.push(item);

            }
        }

        //将s1剩余的运算符加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }


        return s2;

    }


    /**
     * 中缀表达式 转换为集合形式
     *
     * @param s
     * @return
     */
    public static List<String> toInffixExpresion(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;//用于遍历字符串
        String str = "";//多位数的操作
        char c;
        do {
            //如果c是一个非数字，加入到集合中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(String.valueOf(c));
                i++;
            } else {
                //如果是一个数考虑多位数的问题
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {

                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < s.length());
        return ls;
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

/**
 * 编写一个类，可以返回一个运算符对应的优先级
 */
class Operation {

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;


    /**
     * 写一个方法返回对应的优先级的数字
     */
    public static int getValus(String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;

        }

        return res;
    }


}
