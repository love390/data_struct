package com.cgg.sort.selectsort;

import com.cgg.SectionTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-19 15:45:32
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 * <p>
 * 大顶堆
 * </p>
 */
public class Heap {
    List<Integer> list;


    /**
     * 内部第一个下标不使用
     */
    public Heap() {
        list = new ArrayList<>();
        Integer obj = 0;
        this.list.add(obj);
    }

    /**
     * 内部第一个下标不使用
     *
     * @param list
     */
    public Heap(List<Integer> list) {
        this.list = new ArrayList<>();
        Integer obj = 0;
        this.list.add(obj);
        for (int i = 0; i < list.size(); i++) {
            this.push(list.get(i));
        }
    }


    /**
     * 上浮
     *
     * @param index
     */
    private void shiftUp(int index) {
        while (index >> 1 >= 1) {
            if (list.get(index) > list.get(index >> 1)) {
                this.swap(index, index >> 1);
                index /= 2;
            } else break;
        }
    }


    /**
     * 下沉
     *
     * @param index
     */
    private void shiftDown(int index) {
        while (index << 1 < list.size()) {
            int tmp = index << 1;
            if ((tmp + 1) < list.size() && list.get(tmp) < list.get(tmp + 1)) {//取出孩子节点中最打的元素下标
                tmp = tmp + 1;
            }
            if (list.get(tmp) > list.get(index)) {//父节点比最大的孩子节点小，则下浮
                this.swap(tmp, index);
                index = tmp;
            } else break;
        }
    }

    /**
     * 交换
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        java.lang.Integer tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    /**
     * 向最后压入元素
     *
     * @param obj
     */
    public void push(Integer obj) {
        list.add(obj);
        shiftUp(list.size() - 1);
    }

    /**
     * 取出堆顶元素
     */
    public Integer pop() {
        Integer obj = list.get(1);
        swap(1, list.size() - 1);
        list.remove(list.size() - 1);
        shiftDown(1);
        return obj;
    }

    /**
     * 获取大小
     *
     * @return
     */
    public int size() {
        return list.size() - 1;
    }


    /**
     * 堆排序
     *
     * @return
     */
    public List heatSort() {
        List list = new ArrayList();
        while (this.list.size() > 1) {
            list.add(this.pop());
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) throws Exception {
        List list = SectionTools.getRandomData(10, 1200000, 1000000);
        long start = System.currentTimeMillis();
        Heap heap = new Heap(list);
        list = heap.heatSort();
        long end = System.currentTimeMillis();
        long time = end - start;
        if (SectionTools.test(list)) System.out.println("排序数组用时" + time + "ms");
        else System.out.println("排序失败" + time + "ms");
    }
}
