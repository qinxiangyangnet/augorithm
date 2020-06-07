package com.yueyang.datastruct.tree;

/**
 * @program: augorithm
 * @description: 线索化二叉树
 * 线索二叉树基本介绍
 * 1）n个结点的二叉链表中含有n+1  【公式 2n-(n-1)=n+1】 个空指针域。利用二叉链表中的空指针域，
 * 存放指向该结点在某种遍历次序下的前驱和后继结点的指针（这种附加的指针称为"线索"）
 * 2）这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(Threaded BinaryTree)。
 * 根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
 * 3）一个结点的前一个结点，称为前驱结点
 * 4）一个结点的后一个结点，称为后继结点
 * @author: qinxiangyang
 * @create: 2020-05-22 21:32
 **/
public class ThreadedBinaryTree {

    private HeroNode root;

    //为了实现线索化，需要创建指向当前节点的前去节点的指针
    //pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(ThreadedBinaryTree.HeroNode root) {
        this.root = root;
    }


    /**
     * 前线索化二叉树
     */

    public void preThreadedNodes() {
        this.preThreadedNodes(root);
    }

    public void preThreadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }

        //线索化当前节点
        //处理当前节点的前驱节点

        if (node.getLeft() == null) {
            //当前节点左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型
            node.setLeftType(1);

        }

        //处理后继节点，下次处理
        if (pre != null && pre.getRight() == null) {
            pre.right = node;
            pre.setRightType(1);
        }

        pre = node;

        //只有当类型为false时才进入，否则进入死循环

        //先线索化左子树
        if (node.leftType != 1) {
            preThreadedNodes(node.getLeft());
        }


        //线索化右子树
        if (node.rightType != 1) {
            preThreadedNodes(node.getRight());
        }


    }

    /**
     * 中序线索化二叉树
     */

    public void midThreadedNodes() {
        this.midThreadedNodes(root);
    }

    public void midThreadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        //先线索化左子树
        midThreadedNodes(node.getLeft());

        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //当前节点左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型
            node.setLeftType(1);
        }

        //处理后继节点，下次处理
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        //线索化右子树
        midThreadedNodes(node.getRight());


    }

    /**
     * 后序线索化二叉树
     */

    public void postThreadedNodes() {
        this.postThreadedNodes(root);
    }

    public void postThreadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }


        //先线索化左子树
        if (node.leftType != 1) {
            postThreadedNodes(node.getLeft());
        }


        //线索化右子树
        if (node.rightType != 1) {
            postThreadedNodes(node.getRight());
        }


        if (node.left == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.right == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

    }

    /**
     * 中序遍历
     */
    public void midOrderTree() {
        if (root == null) {
            return;
        }
        HeroNode temp = root;
        while (temp != null) {
            //循环找到leftType=1的节点
            while (temp.getLeftType() == 0) {
                temp = temp.left;
            }

            //打印当前节点
            System.out.println(temp);

            //如果当前节点的右指针指向的是后继节点一直输出
            while (temp.getRightType() == 1) {
                temp = temp.right;

                System.out.println(temp);
            }

            //替换这个遍历的节点
            temp = temp.getRight();
        }


    }

    /**
     * 前序遍历
     */

    public void preOrderTree() {
        HeroNode node = root;
        while (node != null) {
            System.out.println(node);
            if (node.leftType == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     */

//    public void postOrderTree() {
//        HeroNode node = root;
//        while (node != null) {
//
//            while (node.leftType == 0) {
//                node = node.left;
//            }
//            System.out.println(node);
//            while (node.rightType == 1) {
//                node = node.right;
//                System.out.println(node);
//
//            }
//            node=node.right;
//
//        }
//    }


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

        //如果leftType=0，指向的是左子树，如果为1，表示指向前驱节点
        //如果rightType=0，指向的是右子树，如果为1，表示指向后继节点
        private int leftType;
        private int rightType;

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }


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