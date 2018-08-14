package com.cgg.sort.mergesort;

import com.cgg.SectionTools;
import com.cgg.sort.Sort;
import com.cgg.sort.selectsort.SimpleSelectSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-13 18:54:04
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class MergeSort implements Sort {

    /**
     * []
     * @param list
     * @param start
     * @param end
     */
    @Override
    public void sort(List<Integer> list, int start, int end) {
        mergeSort(list, start, end);
    }


    private void mergeSort(List<Integer> list, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(list, start, mid);
            mergeSort(list, mid + 1, end);
            merge(list, start, mid, end);
        }
    }

    /**
     * [start,mid],(mid,end]
     * @param list
     * @param start
     * @param mid
     * @param end
     */
    private void merge(List<Integer> list, int start, int mid, int end) {
        List<Integer> listTmp = new ArrayList<>();
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {//将排好序的两个数组中的最小的加入缓存数组
            if (list.get(i) < list.get(j)) {
                listTmp.add(list.get(i));
                i++;
            } else {
                listTmp.add(list.get(j));
                j++;
            }
        }
        //将未遍历完成的加入进去
        if (i > mid) {
            for (int index = j; index <= end; index++) {
                listTmp.add(list.get(index));
            }
        } else {
            for (int index = i; index <= mid; index++) {
                listTmp.add(list.get(index));
            }
        }

        //更新到主lis返回
        for (int index = start; index <= end; index++) {
            list.set(index, listTmp.get(index - start));
        }
    }

    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 150, 800000);
//        SectionTools.print(list);
//        new MergeSort().sort(list, 0, list.size() - 1);
//        SectionTools.print(list);
//        System.out.println(SectionTools.test(list));
        SectionTools.sortTime(MergeSort.class, list);
    }
}
