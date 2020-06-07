package com.yueyang.datastruct.linkList;

import org.junit.Test;

import java.util.Stack;

/**
 * @program: augorithm
 * @description: 第一种方法在添加英雄时，直接添加到链表的尾部
 * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
 * @author: qinxiangyang
 * @create: 2020-05-07 08:28
 **/
public class SingleLinkList {


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
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {

                break;
            } else if (temp.next.no == heroNode.no) {
                //说明编号存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("编号已经存在" + heroNode.no);
            return;
        }

        //位置找到.后面插入位置
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    /**
     * 修改节点信息，根据编号来修改，即编号不变
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
     */
    public void remove(int no) {
        HeroNode temp = head.next;
        boolean flag = false;


        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.println("没有找到该节点，无法删除" + no);
        }
        temp.next = temp.next.next;
    }


    /**
     * 获取单链表的有效数据，如果带头结点的链表，需要不统计头结点
     */

    public int size() {
        if (head.next == null) {
            return 0;
        }

        int size = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    /**
     * 查找单链表的倒数第k个节点
     * <p>
     * 思路如下
     * 编写一个方接受index
     * 先把链表从头到尾遍历，看看有几个节点，
     * 得到 链表，遍历size-index个节点
     */

    public HeroNode getKInvert(int index) {
        int size = size();
        if (index > size) {
            System.out.println("输入的值超过链表的长度");
            return null;
        }
        int location = size - index;
        HeroNode temp = head.next;
        while (location != 0) {
            if (temp == null) {
                break;
            }
            location--;
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 遍历节点
     */

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
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
     * 单链表的节点反转
     * <p>
     * 1，定义一个新的节点  reverts
     * 2，从头到尾遍历原来的链表，就将其取放在链表的最前端
     * 3，原来的链表的head.next=reverts.next
     */
    public void revert() {
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode revertHeads = new HeroNode(0, "", "");

        HeroNode temp = head.next;
        HeroNode next = null;

        //遍历原来的链表，
        while (temp != null) {
            //暂时保存当前的节点
            next = temp.next;
            //临时节点的下一个节点指向新的节点最前端
            HeroNode tempHead = revertHeads.next;//保存新链表的下一个节点
            revertHeads.next = temp;//将临时的节点加到新的链表上
            revertHeads.next.next = tempHead;

            //后移
            temp = next;
        }

        head.next = revertHeads.next;
    }


    /**
     * 从尾到头  打印单链表
     * 要求方式
     * 方式 1，反向遍历
     * 先将单链表反转操作，再打印，问题：会破坏原来的单链表，不建议
     * 方式  2，stack栈
     * 利用栈的先进后出的特点LIFO，实现逆序打印
     */
    public void revertPrint() {
        if (head.next == null) {
            System.out.println("空链表。。。");
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();

        HeroNode temp = head.next;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

    /**
     * 合并两个有序链表
     * 合并之后链表依然有序
     */




    @Test
    public void test() {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkList singleLinkList = new SingleLinkList();

//        singleLinkList.addNode(heroNode4);
//        singleLinkList.addNode(heroNode3);
//        singleLinkList.addNode(heroNode2);
//        singleLinkList.addNode(heroNode1);


        //加入按照编号
        singleLinkList.addByOrder(heroNode4);
        singleLinkList.addByOrder(heroNode3);
        singleLinkList.addByOrder(heroNode2);
        singleLinkList.addByOrder(heroNode1);


        //修改节点
//        HeroNode heroNode = new HeroNode(3, "李逵", "黑旋风");
//        singleLinkList.update(heroNode);

        //删除
        // singleLinkList.remove(3);
        //System.out.println(singleLinkList.size());

        //获取倒数第三个节点
//        HeroNode kInvert = singleLinkList.getKInvert(2);
//        System.out.println(kInvert);

        singleLinkList.list();

        System.out.println("");

        //反转
//        singleLinkList.revert();
//        singleLinkList.list();

        //逆序打印
        singleLinkList.revertPrint();

    }


}

