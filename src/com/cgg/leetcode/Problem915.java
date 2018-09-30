package com.cgg.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: cgg
 * @Date: 18-9-30 下午4:53
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem915 {
    private PriorityQueue<Integer> right;
    private PriorityQueue<Integer> left;

    /**
     * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
     * <p>
     * left 中的每个元素都小于或等于 right 中的每个元素。
     * left 和 right 都是非空的。
     * left 要尽可能小。
     * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
     *
     * 100%AC
     * 56/56 330MS
     *
     * 使用优先队列获取左右最大最小值
     *
     * @param A
     * @return
     */
    public int partitionDisjoint(int[] A) {
        this.right = new PriorityQueue<>();
        this.left = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : A) this.right.add(i);

        for (int i = 0; i < A.length; i++) {
            this.right.remove(A[i]);
            this.left.add(A[i]);
//            System.out.println(A[i]+" "+this.left.peek() + " " + this.right.peek());
            if (this.left.peek()<=this.right.peek()) break;
        }
//        System.out.println(A.length + " " + this.right.size());
        return this.right.size() == A.length ? 0 : A.length - this.right.size();
    }

    public static void main(String[] args) {
        Problem915 problem915 = new Problem915();
        int[] A = {5, 0, 3, 8, 6};
        System.out.println(problem915.partitionDisjoint(A));
        A = new int[]{32,57,24,19,0,24,49,67,87,87};
        System.out.println(problem915.partitionDisjoint(A));
    }
}
