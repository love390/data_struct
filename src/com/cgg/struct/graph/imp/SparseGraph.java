package com.cgg.struct.graph.imp;

import com.cgg.struct.graph.Graph;
import com.cgg.struct.union.QuickUnion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-05 12:49:13
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * 稀疏图，使用邻接矩阵
 */
public class SparseGraph extends Graph {
    private Vector<Vector<Integer>> graph;

    public SparseGraph(int e, int v, boolean direct) {
        super(e, v, direct);
        this.graph = new Vector<>();
        for (int i = 0; i < v; i++)
            this.graph.add(new Vector<>());
        this.isVisited = new boolean[v];
        this.quickUnion = new QuickUnion(v);
        init();
    }

    public SparseGraph(String filePath, boolean direct) throws FileNotFoundException {
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
        this.graph = new Vector<>();
        for (int i = 0; i < this.v; i++) this.graph.add(new Vector<>());
        this.isVisited = new boolean[v];
        this.quickUnion = new QuickUnion(v);

        for (int i = 0; i < this.e; i++) {
            s = scanner.nextLine().split("\\s+");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            this.graph.get(v1).add(v2);
            this.quickUnion.union(v1, v2);
            if (!this.direct) {
                this.graph.get(v2).add(v1);
            }
        }
        scanner.close();
    }

    private void init() {
        for (int i = 0; i < this.e; i++) {
            while (true) {
                int x = (int) (Math.random() * v);
                int y = (int) (Math.random() * v);
                if (x != y && !this.graph.get(x).contains(y)) {
                    this.graph.get(x).add(y);
                    this.quickUnion.union(x, y);
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
//        Graph sparseGraph = new SparseGraph(20, 10, false);
        String path = Graph.class.getResource("").getPath() + "graph.txt";
        Graph sparseGraph = new SparseGraph(path, false);
        sparseGraph.print();

        System.out.println("稀疏图深度优先遍历");
        sparseGraph.dfs(0);
        sparseGraph.reset();
        System.out.println();

        System.out.println("稀疏图广度优先遍历");
        sparseGraph.bfs(0);
        sparseGraph.reset();
        System.out.println();

        System.out.println("使用深度遍历求连通分量");
        System.out.println("连通分量数：" + sparseGraph.connectedComponent());

        System.out.println("使用并查集求连通分量");
        System.out.println("连通分量数：" + sparseGraph.connectedComponentByUnion());
    }
}
