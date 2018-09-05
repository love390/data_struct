package com.cgg.struct.graph;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-05 12:50:51
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public abstract class Graph {
    protected int e;//边
    protected int v;//顶点
    protected boolean direct;//是否有向

    public Graph(int v, boolean direct) {
        this.v = v;
        this.direct = direct;
    }

    public Graph(int e, int v, boolean direct) {
        this.e = e;
        this.v = v;
        this.direct = direct;
    }

    public int getE() {
        return e;
    }

    public int getV() {
        return v;
    }

    public abstract void dfs(int v);

    public abstract void bfs(int v);

    public abstract void print();
}
