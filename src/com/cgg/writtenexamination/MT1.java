package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-9 下午8:51
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class MT1 {

    private boolean[] isVisited;
    private int rs;

    /**
     * 美团点评校招
     * 给张优惠券，求能用该券时最少花多少钱就行
     *
     * AC 30%出头,超时
     * @param n 菜数量
     * @param x 券面值
     * @param money 各个菜的价格
     * @return
     */
    public int find(int n, int x, int[] money) {
        this.rs = 0;
        this.isVisited = new boolean[money.length];
        this.findE(n, x, money, 0);
        return this.rs;
    }

    private void findE(int n, int x, int[] money, int curMoney) {
        if (curMoney >= x) {
            if (rs < n) rs = curMoney;
            else rs = Math.min(rs, curMoney);
            return;
        }
        for (int i = 0; i < money.length; i++) {
            if (this.isVisited[i] == false) {
                this.isVisited[i] = true;
                findE(n, x, money, curMoney + money[i]);
                this.isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MT1 MT1 = new MT1();
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(data[0]);
            int x = Integer.parseInt(data[1]);
            int[] money = new int[n];

            data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length; i++) money[i] = Integer.parseInt(data[i]);
            System.out.println(MT1.find(n, x, money));
        }
        scanner.close();
    }
}
