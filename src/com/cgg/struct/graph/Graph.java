package com.cgg.struct.graph;

import com.cgg.struct.union.QuickUnion;

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
    protected QuickUnion quickUnion;//并查集，快速找到连通分量和判断两点是否连通
    protected boolean isVisited[];//保存遍历状态

    public Graph() {
    }

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

    public void setE(int e) {
        this.e = e;
    }

    public void setV(int v) {
        this.v = v;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public abstract void dfs(int v);//深度遍历

    public abstract void bfs(int v);//广度遍历

    public abstract void print();//打印图

    public abstract int connectedComponent();//dfs连通分量

    public abstract int connectedComponentByUnion();//并查集连通分量

    public boolean isConnected(int v1, int v2) {//并查集判断两顶点是否连通
        if (!check(v1) || !check(v2))
            throw new IllegalArgumentException("顶点不存在");
        return this.quickUnion.isConnected(v1, v2);
    }

    protected boolean isAllvisited() {//是否所有点都遍历了
        for (int i = 0; i < this.v; i++) {
            if (!this.isVisited[i]) {
                return false;
            }
        }
        return true;
    }

    public void reset() {//重置遍历状态
        for (int i = 0; i < this.v; i++) this.isVisited[i] = false;
    }

    protected boolean check(int v) {
        if (v >= this.v || v < 0) return false;
        else return true;
    }
}
