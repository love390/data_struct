package com.cgg.struct.union;

import java.util.Random;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-20 14:40:15
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * <p>
 * 并查集
 */
public class QuickUnion {
    private int[] array;

    public QuickUnion(int size) {
        this.array = new int[size];
        for (int i = 0; i < size; i++) this.array[i] = i;
    }

    /**
     * 是否连接
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isConnected(int i, int j) {
        return this.parent(i) == this.parent(j);
    }

    /**
     * 连接两个点
     *
     * @param i
     * @param j
     */
    public void union(int i, int j) {
        this.array[this.parent(i)] = this.parent(j);
    }


    /**
     * 寻找节点父亲
     *
     * @param index
     * @return
     */
    public int parent(int index) {
        while (this.array[index] != index) {
            this.array[index]=this.array[this.array[index]];//路径压缩
            index = this.array[index];
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 100;
        QuickUnion quickUnion = new QuickUnion(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            quickUnion.union(x, y);
            System.out.print(x + " 连接" + y + "\t");
        }

        for (int i = 0; i < n; i++) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            System.out.println(x + " 是否连接" + y + ":" + quickUnion.isConnected(x, y));
        }
    }
}