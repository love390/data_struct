package com.cgg.writtenexamination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-15 20:26:08
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem3 {
    public int find(ArrayList<Integer> integers) {
        int rsNum = 0;
        int rsCount = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : integers) {
            if (hashMap.containsKey(integer)) {
                hashMap.put(integer, hashMap.get(integer) + 1);
            } else {
                hashMap.put(integer, 1);
            }
            int tmp = hashMap.get(integer);
            if(tmp>rsCount){
                rsCount=tmp;
                rsNum=integer;
            }
        }
        return rsNum;
    }

    /**
     * 搜狐畅游笔试题，随机一串数字，，返回重复次数最多的数字
     * 另外一个求链表是否有环，并返回环入口的简单题，只要用个并查集即可，具体代码就不写了，也很简单
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integers;
        Problem3 problem3 = new Problem3();
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().trim().split("\\s+");
            integers = new ArrayList<>();
            for (String s : data) {
                integers.add(Integer.parseInt(s));

            }
            System.out.println(problem3.find(integers));
        }
        scanner.close();
    }
}
