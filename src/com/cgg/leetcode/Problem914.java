package com.cgg.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: cgg
 * @Date: 18-9-30 下午4:08
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem914 {

    private static int MIN_COUNT = 2;

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     *
     * 100%AC
     * 49/49 40MS
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {//记录不同数出现的次数
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else map.put(i, 1);
        }

        int tmp = Integer.MAX_VALUE;//获取最少出现的次数
        for (Integer obj : map.values()) {
            tmp = Math.min(obj, tmp);
        }
        if (tmp < 2) return false;

        int tmpMin = Integer.MAX_VALUE;
        for (Integer obj : map.values()) {//将所有不同数组出现的次数和2~tmp做模运算,若结果都不为0,说明存在数根本没法分割
            boolean flag = false;
            for (int i = 2; i <= tmp; i++) {
                if (obj % i == 0) flag = true;
            }
            if (!flag) return false;

        }
        if (tmpMin >= 2) return true;//上面已经检测了tmpMin~以上是存在解的,只要符合最小拍数大于等于2就ok了
        else return false;
    }

    public static void main(String[] args) {
        Problem914 problem914 = new Problem914();
        int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(problem914.hasGroupsSizeX(deck) == false);
        deck = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(problem914.hasGroupsSizeX(deck) == true);
        deck = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        System.out.println(problem914.hasGroupsSizeX(deck) == true);
        deck = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(problem914.hasGroupsSizeX(deck) == true);
        deck = new int[]{1,1,1,2,2,2,3,3};
        System.out.println(problem914.hasGroupsSizeX(deck) == false);
    }
}
