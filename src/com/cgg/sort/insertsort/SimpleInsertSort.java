package com.cgg.sort.insertsort;

import com.cgg.SectionTools;
import com.cgg.sort.Sort;
import com.cgg.sort.swapsort.QuickSort;

import java.util.List;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-13 17:04:43
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class SimpleInsertSort implements Sort {
    @Override
    public void sort(List<Integer> list, int start, int end) {
        for (int i = 1; i < list.size(); i++) {
            int tmp = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (tmp < list.get(j)) {
                    SectionTools.swap(list, j, j + 1);
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 1200000, 10000);
//        SectionTools.print(list);
//        new SimpleInsertSort().sort(list, 0, list.size() - 1);
//        SectionTools.print(list);
//        System.out.println(SectionTools.test(list));

        SectionTools.sortTime(SimpleInsertSort.class, list);

    }
}
