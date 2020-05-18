package com.yueyang.augorithm.tree;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-18 21:48
 **/
public class Test {


    @org.junit.Test
    public void testBinaryTree() {


        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        BinaryTree.HeroNode root = new BinaryTree.HeroNode(1, "宋江");
        BinaryTree.HeroNode node2 = new BinaryTree.HeroNode(2, "吴用");
        BinaryTree.HeroNode node3 = new BinaryTree.HeroNode(3, "卢俊义");
        BinaryTree.HeroNode node4 = new BinaryTree.HeroNode(4, "林冲");
        BinaryTree.HeroNode node5 = new BinaryTree.HeroNode(5, "李逵");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //前序遍历
        System.out.println("前序遍历---------------------");
        binaryTree.preOrder();

        //中序遍历
        System.out.println("中序遍历---------------------");
        binaryTree.midOrder();

        //后序遍历
        System.out.println("后序遍历---------------------");
        binaryTree.aftOrder();

    }
}