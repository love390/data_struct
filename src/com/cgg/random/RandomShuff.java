package com.cgg.random;

import java.util.ArrayList;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-05 11:17:29
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * <p>
 * 随机洗牌
 */
public class RandomShuff {
    private int count;//总随机次数
    private int n;//随机成true的个数
    private int m;//数组长度

    private ArrayList<Boolean> list;
    private ArrayList<Integer> rs;

    public RandomShuff(int count, int n, int m) {
        if (n > m)
            throw new IllegalArgumentException("n 比小");
        this.count = count;
        this.n = n;
        this.m = m;

        this.list = new ArrayList<>();
        this.rs = new ArrayList<>();

        for (int i = 0; i < this.m; i++) {
            this.rs.add(0);
        }
    }

    public void run() {
        for (int i = 0; i < this.count; i++) {
            reset();
            shuff();
            record();
        }
        printRs();
    }

    private void reset() {
        this.list.clear();
        for (int i = 0; i < this.m; i++) {
            if (i < this.n) {
                this.list.add(true);
            } else this.list.add(false);
        }
    }

    /**
     * [0,i]未随机部分，(i,m-i-1]已随机部分
     */
    private void shuff() {
        for (int i = this.m - 1; i >= 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            swap(i, index);
        }
    }

    private void swap(int i, int j) {
        if (!inArray(i) || !inArray(j))
            throw new IllegalArgumentException("下表越界");
        boolean b = this.list.get(i);
        this.list.set(i, this.list.get(j));
        this.list.set(j, b);
    }

    private boolean inArray(int index) {
        return (index >= 0 && index < this.m) ? true : false;
    }

    private void record() {
        for (int i = 0; i < this.m; i++) {
            if (this.list.get(i))
                this.rs.set(i, this.rs.get(i) + 1);
        }
    }

    private void printRs() {
        for (int i = 0; i < this.m; i++) {
            System.out.println("下标" + i + "为true实际概率:" + (this.rs.get(i) / (this.count * 1.000)) + " 期望：" + (this.n / (this.m * 1.000)));
        }
    }

    public static void main(String[] args) {
        new RandomShuff(10000000, 2, 10).run();
    }
}
