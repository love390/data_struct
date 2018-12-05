package com.cgg.leetcode;

import java.util.*;

public class Problem39 {
    private HashMap<Integer, List<List<Integer>>> hashMap;
    private HashSet<Integer> integers;

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * 示例 2:
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     *
     * 超时
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length <= 0) return new ArrayList<>();
        if (target < candidates[0]) return new ArrayList<>();

//        int total=0;
//        for(int i:candidates)total+=i;
//        if(total<target)return new ArrayList<>();

        this.hashMap = new HashMap<>();
        this.integers = new HashSet<>();
        for (int i : candidates) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(i);
            List<List<Integer>> arrayLists = new ArrayList<>();
            arrayLists.add(integers);

            this.hashMap.put(i, arrayLists);
            this.integers.add(i);
        }

        for (int start = candidates[0]; start <= target; start++) {
            for (int index = candidates[0]; index <= start; index++) {
                int rest = start - index;
//                System.out.println(index + " " + rest + " " + start);

                List<List<Integer>> listsTarget = this.hashMap.get(start);
                List<List<Integer>> listsIndex = this.hashMap.get(index);
                List<List<Integer>> listsRest = this.hashMap.get(rest);

                if (listsIndex == null) listsIndex = new ArrayList<>();
                if (listsRest == null) listsRest = new ArrayList<>();
                if (listsTarget == null) listsTarget = new ArrayList<>();

//                System.out.println(listsIndex);
//                System.out.println(listsRest);
//                System.out.println(listsTarget);

//                if (listsIndex.size() <= 0) {
////                    for (List<Integer> integers : listsRest) {
////                        listsTarget.add(integers);
////                    }
////                }
////
////                if (listsRest.size() <= 0) {
////                    for (List<Integer> integers : listsIndex) {
////                        listsTarget.add(integers);
////                    }
////                }

                for (List<Integer> integers1 : listsIndex) {
                    for (List<Integer> integers2 : listsRest) {
                        List<Integer> integers = new ArrayList<>();
                        integers.addAll(integers1);
                        integers.addAll(integers2);
                        listsTarget.add(integers);
                    }
                }

//                if (rest == 0) {
//                    for (List<Integer> integers : listsIndex) {
//                        listsTarget.add(integers);
//                    }
//                }
                this.hashMap.put(start, listsTarget);
            }
        }

//        System.out.println(this.hashMap);
//        System.out.println(this.integers);
        HashSet<String> strings = new HashSet<>();
        List<List<Integer>> lists = this.hashMap.get(target);
        for (List<Integer> integers : lists) {
            Collections.sort(integers);
            strings.add(integers.toString());
        }

        List<List<Integer>> rs = new ArrayList<>();
        for (String s : strings) {

            List<Integer> integers = new ArrayList<>();
            s = s.replaceAll("\\s+", "");
            s = s.replaceAll("\\[", "");
            s = s.replaceAll("\\]", "");
//            System.out.println(s);
            String[] split = s.split(",");
//            System.out.println(Arrays.toString(split));
            for (String s1 : split) {
                integers.add(Integer.parseInt(s1));
            }
            rs.add(integers);
        }
        return rs;
    }


    public static void main(String[] args) {
        Problem39 problem39 = new Problem39();
//        System.out.println(problem39.combinationSum(new int[]{2, 3, 6, 7}, 7));
//        System.out.println(problem39.combinationSum(new int[]{2, 3, 5}, 8));
//        System.out.println(problem39.combinationSum(new int[]{2}, 1));
//        System.out.println(problem39.combinationSum(new int[]{8,7,4,3}, 11));
        System.out.println(problem39.combinationSum(new int[]{7,3,9,6}, 6));
    }
}
