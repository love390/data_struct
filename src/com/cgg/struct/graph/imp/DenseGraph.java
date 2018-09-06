package com.cgg.struct.graph.imp;

import com.cgg.struct.graph.Graph;
import com.cgg.struct.union.QuickUnion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-05 12:48:53
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * 稠密图，使用二维数组
 */
public class DenseGraph extends Graph {
    private boolean graph[][];

    public DenseGraph(int v, boolean direct) {
        super(v, direct);
        this.graph = new boolean[v][v];
        this.isVisited = new boolean[v];
        this.quickUnion = new QuickUnion(v);
        init();
    }

    public DenseGraph(String filePath, boolean direct) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists())
            throw new FileNotFoundException(filePath + "未找到");

        Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)));
        String[] s = scanner.nextLine().split("\\s+");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        this.setV(v);
        this.setE(e);
        this.setDirect(direct);
        this.graph = new boolean[v][v];
        this.isVisited = new boolean[v];
        this.quickUnion = new QuickUnion(v);

        for (int i = 0; i < e; i++) {
            s = scanner.nextLine().split("\\s+");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            graph[v1][v2] = true;
            this.quickUnion.union(v1, v2);
            if (!this.direct) graph[v2][v1] = true;
        }

        scanner.close();
    }


    private void init() {
        for (int i = 0; i < this.v; i++) {
            for (int j = 0; j < this.v; j++) {
                if (this.direct) {
                    this.graph[i][j] = Math.random() > 0.5 ? true : false;
                } else {
                    if (i < j) {
                        this.graph[i][j] = Math.random() > 0.5 ? true : false;
                        this.graph[j][i] = this.graph[i][j];
                    }
                }
                if (this.graph[i][j]) this.quickUnion.union(i, j);
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < this.v; i++) {
            System.out.print("顶点" + i + "：");
            for (int j = 0; j < this.v; j++) {
                if (this.graph[i][j])
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(int v) {
        this.isVisited[v] = true;
        System.out.print("=>" + v);
        for (int i = 0; i < this.v; i++) {
            if (this.graph[v][i] && !this.isVisited[i])
                dfs(i);
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
            int start;
            if (this.direct) start = 0;
            else start = el;
            for (int i = start; i < this.v; i++) {
                if (this.graph[el][i] && !this.isVisited[i]) {
                    queque.addLast(i);
                    this.isVisited[i] = true;
                }
            }
        }
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

    /**
     * 使用并查集来获取连通分量
     *
     * @return
     */
    @Override
    public int connectedComponentByUnion() {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < this.v; i++) {
            int parent = this.quickUnion.parent(i);
            integers.add(parent);
        }
        return integers.size();
    }

    public static void main(String[] args) throws Exception {
//        Graph denseGraph = new DenseGraph(10, false);
        String path = Graph.class.getResource("").getPath() + "graph.txt";
        Graph denseGraph = new DenseGraph(path, false);

        denseGraph.print();

        System.out.println("稠密图深度优先遍历");
        denseGraph.dfs(0);
        denseGraph.reset();
        System.out.println();

        System.out.println("稠密图广度优先遍历");
        denseGraph.bfs(0);
        denseGraph.reset();
        System.out.println();

        System.out.println("使用深度遍历求连通分量");
        System.out.println("连通分量数：" + denseGraph.connectedComponent());

        System.out.println("使用并查集求连通分量");
        System.out.println("连通分量数：" + denseGraph.connectedComponentByUnion());
    }
}
