package com.cgg;

import com.cgg.sort.Sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-13 13:51:49
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class SectionTools {

    public static List getRandomData(int min, int max, int size) throws Exception {
        if (min > max) throw new Exception("上下限错误");
        List list = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max - min + 1) + min);
        }
        return list;
    }

    public static void print(List list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static boolean test(List<Integer> list) {
        Comparable a;
        for (int i = 1; i < list.size(); i++) {
            a = list.get(i - 1);
            if (a.compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void sortTime(Class<? extends Sort> clazz, List list) throws Exception {
        Sort sort = clazz.newInstance();
        long start = System.currentTimeMillis();
        sort.sort(list, 0, list.size() - 1);
        long end = System.currentTimeMillis();
        long time = end - start;
        if (test(list)) System.out.println("排序数组用时" + time + "ms");
        else System.out.println("排序失败" + time + "ms");
    }

    public static void swap(List<Integer> list, int index1, int index2) {
        int tmp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp);
    }

    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 50, 1000);
        print(list);
        System.out.println(test(list));
//        sortTime();
    }
}
