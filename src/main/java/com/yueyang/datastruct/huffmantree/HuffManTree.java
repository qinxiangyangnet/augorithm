package com.yueyang.datastruct.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: augorithm
 * @description: 赫夫曼树
 * @author: qinxiangyang
 * @create: 2020-05-23 13:14
 **/
public class HuffManTree {


    /**
     * 创建赫夫曼树
     *
     * @param arr
     */
    public Node createHuffmanTree(int[] arr) {
        //将数组中的数据转换为节点，并装入集合
        List<Node> list = new ArrayList<>();
        for (int i : arr) {
            Node node = new Node(i);
            list.add(node);
        }

        while (list.size() > 1) {
            //排序
            Collections.sort(list);

            //取出最小的一个节点
            Node left = list.get(0);
            //取出次小的一个节点
            Node right = list.get(1);

            //组装
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            //移除节点
            list.remove(left);
            list.remove(right);

            //添加节点
            list.add(parent);

        }
        return list.get(0);

    }


    /**
     * 前序遍历
     */

    public void preOrder(Node node) {

        if (node == null) {
            System.out.println("空节点，无法遍历");
            return;
        }
        node.preOrder();
    }

    /**
     * 创建节点类
     * 为了让Node  对象持续排序Collection
     * 实现Comparable接口
     */
    class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node o) {
            //表示从小到大排序
            return this.value - o.value;
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
    }
}