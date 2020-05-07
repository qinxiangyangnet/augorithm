package com.yueyang.augorithm.linkList;

import org.junit.Test;

/**
 * @program: augorithm
 * @description: 环形链表，约瑟夫问题
 * 可以带头结点，也可以不带
 * @author: qinxiangyang
 * @create: 2020-05-08 05:31
 **/
public class CircleLinkList {


    public JosephuNode first = new JosephuNode(-1);

    /**
     * 定义节点
     */
    public class JosephuNode {

        private int no;

        public JosephuNode next;

        public void setNo(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public JosephuNode getNext() {
            return next;
        }

        public void setNext(JosephuNode next) {
            this.next = next;
        }

        public JosephuNode(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    +
                            '}';
        }
    }

    /**
     * 添加节点
     */

    public void addNode(int nums) {
        if (nums < 1) {
            System.out.println("numbers的值不正确");
        }

        //帮助构建环形列表
        JosephuNode cur = null;
        //使用for循环
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            JosephuNode josephuNode = new JosephuNode(i);

            //如果是第一个节点
            if (i == 1) {
                first = josephuNode;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(josephuNode);
                josephuNode.setNext(first);
                cur = josephuNode;
            }
        }


    }

    /**
     * 遍历节点
     */
    public void list() {
        if (first == null) {
            System.out.println("空链表");
            return;
        }
        JosephuNode cur = first;
        while (cur.next != first) {
            System.out.println("编号" + cur.no);
            cur = cur.next;
        }
        System.out.println("编号" + cur.no);

    }

    /**
     * * 出圈
     * *根据用户的输入，计算出圈的顺序
     *
     * @param startNo  从哪个编号开始
     * @param countNum 数几下
     * @param nums     总共多少编号
     */
    public void out(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        //创建一个辅助值
        JosephuNode helper = first;

        while (true) {

            if (helper.next == first) {
                //说明最后一个节点
                break;
            }
            helper = helper.next;

        }

        //移动到指定的位置
        for (int j = 0; j < startNo - 1; j++) {
            first = first.next;
            helper = helper.next;
        }

        //开始出圈，循环操作，直到圈中只有一个
        while (true) {
            if (helper == first) {
                //说明圈中只有一人
                break;
            }
            //让first 和helper移动countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println("出圈编号" + first.no);

            //出圈
            first = first.next;
            helper.next = first;
        }

        System.out.println("最后的编号" + first.no);

    }


    @Test
    public void test() {
        CircleLinkList circleLinkList = new CircleLinkList();
        circleLinkList.addNode(5);
        circleLinkList.list();
        circleLinkList.out(1,2,5);
    }

}