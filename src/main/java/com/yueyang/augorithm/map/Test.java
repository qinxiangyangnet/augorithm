package com.yueyang.augorithm.map;

/**
 * @program: augorithm
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-26 20:59
 **/
public class Test {

    /**
     * 测试图
     */
    @org.junit.Test
    public void test() {

        //节点的个数
        int n = 5;
        String[] vertex = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);


        //循环添加顶点
        for (String value : vertex) {
            graph.insertVertex(value);
        }

        //添加边 AB
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        //显示一把邻接矩阵
        graph.showGraph();


    }
}