package com.cgg.struct.graph;

import java.util.LinkedList;
import java.util.Vector;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-05 12:49:13
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * 稀疏图，使用邻接矩阵
 */
public class SparseGraph extends Graph {
    private Vector<Vector<Integer>> graph;
    private boolean isVisited[];

    public SparseGraph(int e, int v, boolean direct) {
        super(e, v, direct);
        this.graph = new Vector<>();
        for (int i = 0; i < v; i++)
            this.graph.add(new Vector<>());
        this.isVisited = new boolean[v];
        init();
    }

    private void init() {
        for (int i = 0; i < this.e; i++) {
            while (true) {
                int x = (int) (Math.random() * v);
                int y = (int) (Math.random() * v);
                if (x != y && !this.graph.get(x).contains(y)) {
                    this.graph.get(x).add(y);
                    if (!this.direct && !this.graph.get(y).contains(x)) {
                        this.graph.get(y).add(x);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void dfs(int v) {
        this.isVisited[v] = true;
        System.out.print("=>" + v);
        for (int next : graph.get(v)) {
            if (!this.isVisited[next])
                dfs(next);
        }
    }

    @Override
    public void bfs(int v) {
        LinkedList<Integer> queque = new LinkedList<>();
        queque.addLast(v);
        this.isVisited[v] = true;
        while (!queque.isEmpty()) {
            int el = queque.pop();
            System.out.print("=>" + el);
            for (int next : graph.get(v)) {
                if (!this.isVisited[next]) {
                    queque.addLast(next);
                    this.isVisited[next] = true;
                }
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < this.v; i++) {
            Vector<Integer> integers = this.graph.get(i);
            System.out.print("顶点" + i + "：");
            for (int obj : integers) {
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }


    public void reset() {
        for (int i = 0; i < this.v; i++) this.isVisited[i] = false;
    }

    @Override
    public int connectedComponent() {
        int rs = 0;
        reset();
        while (!isAllvisited()) {
            for (int i = 0; i < this.v; i++) {
                if (!this.isVisited[i]) {
                    dfs(i);
                    System.out.println();
                    rs++;
                }
            }
        }
        return rs;
    }

    private boolean isAllvisited() {
        for (int i = 0; i < this.v; i++) {
            if (!this.isVisited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SparseGraph sparseGraph = new SparseGraph(20, 10, false);
        sparseGraph.print();

        System.out.println("稀疏图深度优先遍历");
        sparseGraph.dfs(0);
        sparseGraph.reset();
        System.out.println();

        System.out.println("稀疏图广度优先遍历");
        sparseGraph.bfs(0);
        sparseGraph.reset();
        System.out.println();

        System.out.println("连通分量");
        System.out.println("连通分量数：" + sparseGraph.connectedComponent());
    }
}
