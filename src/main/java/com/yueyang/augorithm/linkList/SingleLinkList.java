package com.yueyang.augorithm.linkList;

import org.junit.Test;

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
        HeroNode heroNode = new HeroNode(3, "李逵", "黑旋风");
        singleLinkList.update(heroNode);

        singleLinkList.remove(3);

        singleLinkList.list();

    }


}

