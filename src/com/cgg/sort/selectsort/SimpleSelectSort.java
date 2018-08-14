package com.cgg.sort.selectsort;

import com.cgg.SectionTools;
import com.cgg.sort.Sort;

import java.util.List;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-13 14:17:14
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class SimpleSelectSort implements Sort {
    /**
     * []
     *
     * @param list
     * @param start
     * @param end
     */
    @Override
    public void sort(List<Integer> list, int start, int end) {
        int minIndex;
        for (int i = start; i <= end; i++) {
            minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if (list.get(j) < list.get(minIndex)) minIndex = j;
            }
//            System.out.println(minIndex + " " + list.get(minIndex) + " " + i + " " + list.get(i));
            SectionTools.swap(list, i, minIndex);
        }
    }

    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 30, 80000);
//        SectionTools.print(list);
//        new SimpleSelectSort().sort(list);
//        SectionTools.print(list);
//        System.out.println(SectionTools.test(list));
        SectionTools.sortTime(SimpleSelectSort.class, list);

    }
}
