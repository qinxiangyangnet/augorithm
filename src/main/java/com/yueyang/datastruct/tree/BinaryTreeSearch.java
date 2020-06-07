package com.yueyang.datastruct.tree;

/**
 * @program: augorithm
 * @description: 二叉树
 * @author: qinxiangyang
 * @create: 2020-05-18 21:36
 **/
public class BinaryTreeSearch {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    /**
     * 前序遍历
     */
    public HeroNode preOrder(int no) {
        HeroNode heroNode = null;
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
        } else {
            heroNode = root.preOrder(no);
        }
        return heroNode;
    }

    /**
     * 中序遍历
     */
    public HeroNode midOrder(int no) {
        HeroNode heroNode = null;
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
        } else {
            heroNode = root.midOrder(no);
        }
        return heroNode;
    }

    /**
     * 后序遍历
     */
    public HeroNode aftOrder(int no) {
        HeroNode heroNode = null;
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
        } else {
            heroNode = root.aftOrder(no);
        }
        return heroNode;
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

        public HeroNode preOrder(int no) {
            HeroNode heroNode = null;
            if (this.no == no) {
                return this;
            }

            if (this.left != null) {
                heroNode = this.left.preOrder(no);
            }
            if (heroNode != null) {
                //说明左子树找到树
                return heroNode;
            }

            if (this.right != null) {
                heroNode = this.right.preOrder(no);
            }
            //不管是不是找到都要返回的
            return heroNode;
        }

        /**
         * 中序遍历
         */

        public HeroNode midOrder(int no) {
            HeroNode heroNode = null;
            if (this.left != null) {
                heroNode = this.left.midOrder(no);
            }
            if (heroNode != null) {
                return heroNode;
            }
            if (this.no == no) {
                return this;
            }

            if (this.right != null) {
                heroNode = this.right.midOrder(no);
            }
            return heroNode;
        }

        /**
         * 后序遍历
         */

        public HeroNode aftOrder(int no) {
            HeroNode heroNode = null;
            if (this.left != null) {
                heroNode = this.left.aftOrder(no);
            }

            if (heroNode != null) {
                return heroNode;
            }
            if (this.right != null) {
                heroNode = this.right.aftOrder(no);
            }
            if (heroNode != null) {
                return heroNode;
            }

            //左右子树都没找到，比较当前节点
            if (this.no == no) {
                return this;
            }

            return heroNode;
        }
    }

}