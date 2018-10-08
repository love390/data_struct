package com.cgg.writtenexamination;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-8 下午7:05
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class JRTT1 {
    private HashMap<Integer, Boolean> map;

    public JRTT1() {
        this.map = new HashMap<>();
    }

    /**
     * 一个k位数，满足由a,b构成，且其各个位数和也满足上述条件，则结果+1
     * @param a
     * @param b
     * @param k
     * @return
     */
    public int find(int a, int b, int k) {
        int rs = 0;
        int start = (int) Math.pow(10, k-1);
        int end = (int) Math.pow(10, k);
        for (int index = start; index < end; index++) {
            if (this.map.get(index) != null) {
                if (this.map.get(index) == true) rs++;
                continue;
            }

            if (this.isOk(a, b, index) && this.isOk(a, b, this.sum(index))) {
                rs++;
                this.map.put(index, true);
            } else this.map.put(index, false);
        }
        return rs;
    }

    private boolean isOk(int a, int b, int data) {
        String s = String.valueOf(data);
        s = s.replaceAll(a + "", "");
        s = s.replaceAll(b + "", "");
        return s.length() == 0;
    }

    private int sum(int num) {
        int rs = 0;
        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {
            rs = rs + Integer.parseInt(c + "");
        }
        return rs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JRTT1 JRTT1 = new JRTT1();
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split("\\s+");
            System.out.println(JRTT1.find(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        }
        scanner.close();
    }
}
