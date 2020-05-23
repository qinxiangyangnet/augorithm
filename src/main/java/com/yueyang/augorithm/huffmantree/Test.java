package com.yueyang.augorithm.huffmantree;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-23 14:15
 **/
public class Test {

    /**
     * 测试HuffManTree
     */
    @org.junit.Test
    public void test1() {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        HuffManTree huffManTree = new HuffManTree();
        HuffManTree.Node huffmanTree = huffManTree.createHuffmanTree(arr);
        huffManTree.preOrder(huffmanTree);
    }

}