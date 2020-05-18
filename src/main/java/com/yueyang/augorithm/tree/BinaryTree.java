package com.yueyang.augorithm.tree;

/**
 * @program: augorithm
 * @description: 二叉树
 * @author: qinxiangyang
 * @create: 2020-05-18 21:36
 **/
public class BinaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
        } else {
            root.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
        } else {
            root.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void aftOrder() {
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
        } else {
            root.aftOrder();
        }
    }


    public static class HeroNode {
        //编号
        private int no;
        //名字
        private String name;
        //左节点
        private HeroNode left;
        //right节点
        private HeroNode right;

        //构造
        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getLeft() {
            return left;
        }

        public void setLeft(HeroNode left) {
            this.left = left;
        }

        public HeroNode getRight() {
            return right;
        }

        public void setRight(HeroNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        /**
         * 前序遍历
         */

        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }

            if (this.right != null) {
                this.right.preOrder();
            }
        }

        /**
         * 中序遍历
         */

        public void midOrder() {
            if (this.left != null) {
                this.left.midOrder();
            }
            System.out.println(this);

            if (this.right != null) {
                this.right.midOrder();
            }
        }

        /**
         * 后序遍历
         */

        public void aftOrder() {
            if (this.left != null) {
                this.left.aftOrder();
            }
            if (this.right != null) {
                this.right.aftOrder();
            }
            System.out.println(this);
        }
    }

}