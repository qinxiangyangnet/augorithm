package com.yueyang.augorithm.tree;

/**
 * @program: augorithm
 * @description: 平衡二叉树
 * @author: qinxiangyang
 * @create: 2020-05-26 05:09
 **/
public class AVLTree {

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


    /**
     * 查找要删除的节点
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);

    }

    /**
     * 要删除查找父节点
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);

    }

    /**
     * 返回
     * 删除
     * 两个功能
     *
     * @param node 传入的节点，（当做二叉树的根节点）
     * @return 返回以node为根节点二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node targer = node;
        //循环查找左节点，就会找到最小值
        while (targer.left != null) {
            targer = targer.left;
        }
        //这时targer指向最小节点
        //删除最小节点
        deleteNode(targer.value);
        return targer.value;

    }

    /**
     * 获取根节点
     */
    public Node getRoot() {
        return root;
    }
    /*
    删除节点
     */

    public void deleteNode(int value) {
        if (root == null) {
            System.out.println("删除失败，空二叉树无法删除");
            return;
        } else {
            Node node = search(value);
            if (node == null) {
                //没找到，删除不了
                return;
            }
            //如果找到的是根节点，且只有一个节点
            if (root.value == value && root.left == null && root.right == null) {

                root = null;
                return;
            }
            /**
             * 找到父节点，这里就不可能为空了，因为已经排除根节点的情况
             */
            Node parentNode = searchParent(value);

            //删除叶子节点
            if (node.left == null && node.right == null) {
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }

            } else if (node.left != null && node.right != null) {
                //表示有左右子树
                int min = delRightTreeMin(node.right);
                node.value = min;
            } else {
                //删除 只有一个子树的节点
                //如果要删除的节点有左子节点
                if (node.left != null) {
                    if (parentNode != null) {

                        // 如果targetNode是parent的左子节点， parent.left=targetNode.left;
                        if (parentNode.left.value == value) {
                            parentNode.left = node.left;
                        } else {
                            parentNode.right = node.left;
                        }
                    } else {
                        root = node.left;
                    }
                } else {
                    //说明要删除的节点是有右子节点
                    //,如果targetNode有右子节点
                    if (parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = node.right;
                        } else {
                            parentNode.right = node.right;
                        }
                    } else {
                        root = node.right;
                    }

                }

            }

        }

    }


    public static class Node {
        private int value;
        private Node left;

        private Node right;

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
         * 左旋转
         */
        public void leftRotate() {
            //1,创建新的节点，当前根节点的值作为
            Node newNode = new Node(value);

            //2，把新节点的左子树，设置为当前节点的左子树
            newNode.left = left;

            //3，把新的节点的右子树设置当前节点的右子树的左子树
            newNode.right = this.right.left;

            //4,把当前节点的值替换成右子树的值
            value = right.value;

            //5,把当前节点的右子树设置成右子树的右子树
            right = right.right;

            //6,把当前节点的左子树设置为新的节点
            left = newNode;
        }


        /**
         * 右旋转
         */
        public void rightRotate() {
            //1,创建新的节点，当前节点的值作为
            Node newNode = new Node(value);

            //2，把新节点的右子树，设置为当前节点的右子树
            newNode.right = right;

            //3，把新的节点的左子树设置当前节点的左子树的右子树
            newNode.left = this.left.right;

            //4,把当前节点的值替换成左子树的值
            value = left.value;

            //5,把当前节点的左子树设置成左子树的左子树
            left = left.left;

            //6,把当前节点的右子树设置为新的节点
            right = newNode;
        }


        /**
         * 返回当前节点高度，以该节点为根节点的树的高度
         */
        public int height() {
//加1，他自己本身还占一层
            return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
        }

        /**
         * 返回左子树的高度
         */
        public int leftHeight() {
            if (left == null) {
                return 0;
            }
            return left.height();
        }

        public int rightHeight() {
            if (right == null) {
                return 0;
            }
            return right.height();
        }

        /**
         * 返回右子树的高度
         */


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

            //判断，添加完节点后，如果右子树的高度-左子树的高度>1，左旋转
            if (rightHeight() - leftHeight() > 1) {
                if (right != null && right.leftHeight() > right.rightHeight()) {
                    right.rightRotate();
                    leftRotate();
                } else {

                    leftRotate();//左旋
                }

                return;//必须要，已经平衡了，再往下判断没有意义
            }

            if (leftHeight() - rightHeight() > 1) {
                //判断它的左子树右子树的高度大于左子树的高度
                if (left != null && left.rightHeight() > left.leftHeight()) {
                    //先对当前节点左旋转
                    left.leftRotate();
                    rightRotate();
                } else {
                    //直接进行右旋转
                    rightRotate();
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

        /**
         * 查找要删除的节点
         */
        public Node search(int value) {
            if (this.value == value) {
                return this;
            } else if (this.value > value) {
                //向左子树递归查找
                //如果左子节点为空，就不能再找了
                if (this.left == null) {
                    return null;
                }
                return this.left.search(value);
            } else {
                //向右子树
                if (this.right == null) {
                    return null;
                }
                return this.right.search(value);
            }
        }

        /**
         * 查找要删除的父节点
         */
        public Node searchParent(int value) {
            if ((this.left != null && this.left.value == value)
                    || (this.right != null && this.right.value == value)) {
                return this;
            } else {
                if (this.value > value && this.left != null) {
                    return this.left.searchParent(value);

                } else if (this.value <= value && this.right != null) {
                    return this.right.searchParent(value);
                } else {
                    return null;
                }

            }
        }


    }
}