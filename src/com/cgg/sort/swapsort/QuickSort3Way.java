package com.cgg.sort.swapsort;

import com.cgg.SectionTools;
import com.cgg.sort.Sort;

import java.util.List;
import java.util.Random;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-14 18:49:11
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class QuickSort3Way implements Sort {

    private int randFlagIndex(int start, int end) {
        return new Random().nextInt(end - start + 1) + start;
    }

    /**
     * []
     */
    @Override
    public void sort(List<Integer> list, int start, int end) {
        if (start < end) {
            //随机取分割值优化最坏n^2
            int flagIndex = randFlagIndex(start, end);
            SectionTools.swap(list, flagIndex, start);
            int flag = list.get(start);
            int li = start, cur = start + 1, ri = end;

            while (cur <= ri) {
                while (cur < ri && flag == list.get(cur)) cur++;
                if (flag > list.get(cur)) {
                    li++;
                    SectionTools.swap(list, li, cur);
                    cur++;
                } else {
                    SectionTools.swap(list, ri, cur);
                    ri--;
                }
            }
            SectionTools.swap(list, li, start);

            this.sort(list, start, li-1);
            this.sort(list, cur, end);
        }
    }

    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 1200000, 1000000);
//        SectionTools.print(list);
//        new QuickSort3Way().sort(list, 0, list.size() - 1);
//        SectionTools.print(list);
//        System.out.println(SectionTools.test(list));

        SectionTools.sortTime(QuickSort3Way.class, list);
    }

}
