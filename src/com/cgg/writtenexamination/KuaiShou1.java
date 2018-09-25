package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-25 下午7:46
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class KuaiShou1 {
    /**
     * 快手算法1/3题
     *
     * n个红包砍三刀,最左最右相等,拿最右边红包最大多少
     *
     * 没有全部ac
     * @param moneys
     * @return
     */
    public int compute(int[] moneys) {
        if (moneys.length <= 1) return 0;
        if (moneys.length == 2) {
            if (moneys[0] == moneys[1]) return moneys[0];
            else return 0;
        }

        int leftTotal = 0;
        int total = 0;

        int maxMoney =0;

        for (int i = 0; i < moneys.length; i++) total += moneys[i];

        for (int first = 0; first < moneys.length; first++) {
            int tmp = 0;
            leftTotal += moneys[first];
            for (int second = first + 1; second < moneys.length; second++) {
                tmp = tmp + moneys[second];
                int rightTotal = total - leftTotal - tmp;
                if (rightTotal == leftTotal) maxMoney = Math.max(maxMoney, rightTotal);
            }
        }

        return maxMoney;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        KuaiShou1 kuaiShou1 = new KuaiShou1();
        while (scanner.hasNext()) {
            scanner.nextLine();
            String[] data = scanner.nextLine().trim().split("\\s+");
            int[] moneys = new int[data.length];
            for (int i = 0; i < data.length; i++) moneys[i] = Integer.parseInt(data[i]);
            System.out.println(kuaiShou1.compute(moneys));
        }
        scanner.close();

    }
}
