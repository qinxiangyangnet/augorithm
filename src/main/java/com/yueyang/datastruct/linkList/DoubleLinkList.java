package com.yueyang.datastruct.linkList;

import org.junit.Test;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-07 23:19
 **/
public class DoubleLinkList {

    /**
     * 定义头结点
     */
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * 定义节点
     */
    public class HeroNode {

        private int no;

        private String name;

        private String nickName;

        public HeroNode next;

        public HeroNode pre;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }


    /**
     * 获取头结点
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * 遍历节点
     */

    public void list() {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }

        HeroNode temp = head.next;
        while (true) {

            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }


    /**
     * 添加节点
     *
     * @param heroNode
     */
    public void addNode(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 修改节点信息，根据编号来修改，即编号不变
     * 和单休链表除了节点类型不一样。其他都一样
     */
    public void update(HeroNode newHeroNode) {
        HeroNode temp = head.next;
        //判断是否可以修改
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.println("没有找到该节点" + newHeroNode.no);
            return;
        }

        //修改
        temp.nickName = newHeroNode.nickName;
        temp.name = newHeroNode.name;
    }


    /**
     * 删除节点
     * 对于双向链表，可以找到要删除的这个节点
     * 找到后自我删除
     */
    public void remove(int no) {
        HeroNode temp = head.next;
        boolean flag = false;


        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.println("没有找到该节点，无法删除" + no);
        }

        //自我删除
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
    }

    /**
     * 按照编号添加
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //因为是单链表，所以temp
        HeroNode temp = head;
        //flag标志添加的编号是否存在，默认为false

        boolean flag = false;
        while (true) {
            if (temp.no > heroNode.no) {

                break;
            } else if (temp.no == heroNode.no) {
                //说明编号存在
                flag = true;
                break;
            }
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
                return ;
            }

            temp = temp.next;
        }
        if (flag) {
            System.out.println("编号已经存在" + heroNode.no);
            return;
        }

        //位置找到.后面插入位置
        //注册后面
        HeroNode pre = temp.pre;
        pre.next=heroNode;
        heroNode.pre=pre;

        //注册前面
        heroNode.next=temp;
        temp.pre=heroNode;



    }


    @Test
    public void test() {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        DoubleLinkList doubleLinkList = new DoubleLinkList();
//
//        doubleLinkList.addNode(heroNode4);
//        doubleLinkList.addNode(heroNode3);
//        doubleLinkList.addNode(heroNode2);
//        doubleLinkList.addNode(heroNode1);

        /**
         * 按照编号
         */
        doubleLinkList.addByOrder(heroNode4);
        doubleLinkList.addByOrder(heroNode3);
        doubleLinkList.addByOrder(heroNode2);
        doubleLinkList.addByOrder(heroNode1);

        doubleLinkList.list();

        System.out.println("修改");
        HeroNode heroNode = new HeroNode(3, "公孙胜", "入云龙");
        doubleLinkList.update(heroNode);

        doubleLinkList.list();

    }

}