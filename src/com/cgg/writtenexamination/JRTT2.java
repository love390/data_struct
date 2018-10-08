package com.cgg.writtenexamination;

import java.util.*;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-8 下午7:23
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class JRTT2 {

    class Data {
        int money;
        int level;

        float p;

        public Data(int money, int level) {
            this.money = money;
            this.level = level;
        }

        public int getMoney() {
            return money;
        }

        public int getLevel() {
            return level;
        }
    }

    public Data getNewData(int money, int level) {
        return new Data(money, level);
    }

    /**
     * 有一定数量的金币，给定的装备和容量上限，求可以得到的装备等级最大值
     * @param money
     * @param maxNum
     * @param singles
     * @return
     */
    public int maxDevices(int money, int maxNum, List<Data> singles) {
        int rs = 0;
        for (int i = 0; i < singles.size(); i++) {
            singles.get(i).p = singles.get(i).getLevel() / (singles.get(i).getMoney() * 0.01f);
        }
        Collections.sort(singles, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return (int) (o2.p - o1.p);
            }
        });
        for (int i = 0; i < maxNum; i--) {
            if (money - singles.get(i).getMoney() < 0) break;
            rs = rs + singles.get(i).getLevel();
            money = money - singles.get(i).getMoney();
        }

        return rs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JRTT2 JRTT2 = new JRTT2();
        while (scanner.hasNext()) {
            String money = scanner.nextLine();
            String maxNum = scanner.nextLine();
            List<Data> singles = new ArrayList<>();
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split("\\s+");
                Data data1 = JRTT2.getNewData(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                singles.add(data1);
            }
            System.out.println(JRTT2.maxDevices(Integer.parseInt(money), Integer.parseInt(maxNum), singles));
        }
        scanner.close();
    }
}
