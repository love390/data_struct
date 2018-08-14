package com.cgg.sort.swapsort;

import com.cgg.SectionTools;
import com.cgg.sort.Sort;
import com.cgg.sort.selectsort.SimpleSelectSort;

import java.util.List;
import java.util.Random;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-13 15:28:14
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class QuickSort implements Sort {

    private int randFlagIndex(int start, int end) {
        return new Random().nextInt(end - start+1) + start;
    }

    /**
     * []
     */
    @Override
    public void sort(List<Integer> list, int start, int end) {
        if (start < end) {
            int mid = this.partitionSort(list, start, end);
            this.sort(list, start, mid - 1);
            this.sort(list, mid + 1, end);
        }
    }

    /**
     * ]
     * []
     *
     * @param list
     * @param start
     * @param end
     * @return
     */
    public int partitionSort(List<Integer> list, int start, int end) {
        int x = start + 1;
        int y = end;
        //随机取分割值优化最坏n^2
        int flagIndex = randFlagIndex(start, end);
        SectionTools.swap(list, flagIndex, start);
        int flag = list.get(start);
        while (x < y) {
            if (list.get(x) > flag) {
                SectionTools.swap(list, x, y);
                y--;
            } else x++;
        }
        if (list.get(x) > flag) SectionTools.swap(list, --x, start);
        else SectionTools.swap(list, x, start);
        return x;
    }

    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 800000, 800000);
//        SectionTools.print(list);
//        new QuickSort().sort(list, 0, list.size() - 1);
//        SectionTools.print(list);

        SectionTools.sortTime(QuickSort.class, list);

    }
}
