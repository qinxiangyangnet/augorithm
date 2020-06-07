package com.yueyang.datastruct.linkList;

import java.util.Stack;

/**
 * @program: augorithm
 * @description:演示栈
 * @author: qinxiangyang
 * @create: 2020-05-07 22:47
 **/
public class TestStack {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();


        //入栈
        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");

        //出站
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}