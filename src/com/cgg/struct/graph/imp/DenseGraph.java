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
 * @Date 2018-09-05 12:48:53
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * 稠密图，使用二维数组
 */
public class DenseGraph extends Graph {
    private Integer graph[][];

    public DenseGraph(int v, boolean direct) {
        super(v, direct);
        this.graph = new Integer[v][v];
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
        this.graph = new Integer[v][v];
        this.isVisited = new boolean[v];
        this.quickUnion = new QuickUnion(v);

        for (int i = 0; i < e; i++) {
            s = scanner.nextLine().split("\\s+");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int dis = Integer.parseInt(s[2]);
            graph[v1][v2] = dis;
            this.quickUnion.union(v1, v2);
            if (!this.direct) graph[v2][v1] = dis;
        }

        scanner.close();
    }


    private void init() {
        for (int i = 0; i < this.v; i++) {
            for (int j = 0; j < this.v; j++) {
                if (this.direct) {
                    this.graph[i][j] = Math.random() > 0.5 ? 1 : 0;
                } else {
                    if (i < j) {
                        this.graph[i][j] = Math.random() > 0.5 ? 1 : 0;
                        this.graph[j][i] = this.graph[i][j];
                    }
                }
                if (this.graph[i][j] == 1) this.quickUnion.union(i, j);
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < this.v; i++) {
            System.out.print("顶点" + i + "：");
            for (int j = 0; j < this.v; j++) {
                if (this.graph[i][j] != null)
                    System.out.print(j + "路径长度" + this.graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(int v) {
        this.isVisited[v] = true;
        System.out.print("=>" + v);
        for (int i = 0; i < this.v; i++) {
            if (this.graph[v][i] != null && !this.isVisited[i])
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
                if (this.graph[el][i] != null && !this.isVisited[i]) {
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

    @Override
    public Integer dijkstra(int start, int end) {
        if (!check(start) || !check(end))
            throw new IllegalArgumentException("参数越界");
        this.distance = new int[this.v];
        this.path = new int[this.v];
        for (int i = 0; i < this.v; i++) {
            if (this.graph[start][i] != null) {
                this.distance[i] = this.graph[start][i];
                this.path[i] = start;
            } else this.distance[i] = 100;
        }
        this.reset();
        dijkstra(start);
        this.reset();

        Stack<Integer> integers = new Stack<>();
        integers.push(end);
        int index = end;
        while (this.path[index] != 0) {
            integers.push(this.path[index]);
            index = this.path[index];
        }
        integers.push(start);
        System.out.print("起点"+start+"终点"+end+"路径");
        while (!integers.empty()) {
            System.out.print("=》" + integers.pop());
        }
        System.out.println();
        return this.distance[end];
    }

    private void dijkstra(int v) {
        this.isVisited[v] = true;
        for (int i = 0; i < this.v; i++) {
            if (this.graph[v][i] != null && !this.isVisited[i])//松弛操作
                if (this.graph[v][i] + this.distance[v] < this.distance[i]) {
                    this.distance[i] = this.graph[v][i] + this.distance[v];
                    this.path[i] = v;
                }
        }

        Integer next = null;
        for (int i = 0; i < this.v; i++) {
            if (!this.isVisited[i]) {
                if (next == null) next = i;
                else if (this.distance[next] > this.distance[i]) next = i;
            }
        }
        if (next == null) return;
        dijkstra(next);
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

        System.out.println("使用dijkstra求最短路径");
        System.out.println("最短路径：" + denseGraph.dijkstra(0, denseGraph.getV() - 1));
    }
}
