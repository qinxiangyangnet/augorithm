package com.yueyang.datastruct.stack;

import org.junit.Test;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-09 20:35
 **/
public class TestStack {

    /**
     * 测试用例
     */
    @Test
    public void test() {
        StackArray stackArray = new StackArray(3);
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);

        stackArray.list();

        System.out.println("----------");
        stackArray.pop();
        stackArray.list();

    }
}