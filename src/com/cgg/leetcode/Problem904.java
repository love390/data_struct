package com.cgg.leetcode;

import java.util.HashMap;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 20:36:20
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem904 {
    /**
     * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
     * 你可以从你选择的任何树开始，然后重复执行以下步骤：
     * <p>
     * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
     * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
     * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
     * <p>
     * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
     * 用这个程序你能收集的水果总量是多少？
     *
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        int rsSize = 1;

        int start = 0;
        int end = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(tree[start], 1);
        while (start < tree.length && end < tree.length) {
            if (hashMap.containsKey(tree[end])) {
                hashMap.put(tree[end], hashMap.get(tree[end]) + 1);
                end++;
            } else {
                if (hashMap.size() >= 2 ) {
                    hashMap.put(tree[start], hashMap.get(tree[start]) - 1);
                    if (hashMap.get(tree[start]) == 0) hashMap.remove(tree[start]);
                    start++;
                } else {
                    hashMap.put(tree[end], 1);
                    end++;
                }
            }
            rsSize = Math.max(rsSize, end - start);
        }
        return rsSize;
    }

    public static void main(String[] args) {
        int[] tree = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        Problem904 problem904 = new Problem904();
        System.out.println(problem904.totalFruit(tree));
    }
}
