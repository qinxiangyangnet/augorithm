package com.yueyang.augorithm.map;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: augorithm
 * @description: 图
 * @author: qinxiangyang
 * @create: 2020-05-26 20:43
 **/
public class Graph {


    /**
     * 存储顶点的集合
     */
    private ArrayList<String> vertexList;

    /**
     * 存储对应得邻接矩阵
     */
    private int[][] edges;

    /**
     * 表示边的数目
     */
    private int numofEdges;


    /**
     * 构造器
     *
     * @param n
     */
    public Graph(int n) {
        //初始化
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numofEdges = 0;
    }

    /**
     * 返回节点的个数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 获取边的数目
     */

    public int getNumofEdges() {
        return numofEdges;
    }

    /**
     * 返回节点i的数据
     */
    public String getValueByIndex(int value) {
        return vertexList.get(value);
    }

    /**
     * 返回v1,v2的值
     */
    public int wightValue(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 显示图的矩阵
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


    /**
     * //插入节点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * v1：点的下标，即第几个节点
     * v2:第二个顶点对应得下标
     * weight：表示权重
     */
    public void insertEdge(int v1, int v2, int weight) {
        //无向图
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numofEdges++;

    }
}