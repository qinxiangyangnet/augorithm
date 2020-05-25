package com.yueyang.augorithm.tree;

/**
 * @program: augorithm
 * @description: 二叉排序树
 * @author: qinxiangyang
 * @create: 2020-05-25 20:54
 **/
public class BinarySortTree {


    public static  class Node {
        int value;

        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        /**
         * 递归添加节点
         */

        public void add(Node node) {

            if (node == null) {
                return;
            }

            //判断传入节点的值和当前节点根节点的值关系
            if (node.value < this.value) {
                //添加的值小于当前节点的值
                if (this.left == null) {
                    this.left = node;
                } else {
                    //递归向左子树添加
                    this.left.add(node);
                }
            } else {
                //如果添加的值大于当前节点的值
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }


        /**
         * 中序遍历
         */
        public void preOrder() {
            if (this.left != null) {
                this.left.preOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.preOrder();
            }

        }
    }


    private Node root;

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            //如果root为空
            root = node;
            return;
        }
        root.add(node);
    }

    /**
     * 遍历
     */
    public void infixOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        root.preOrder();
    }

}