package com.cgg.leetcode;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-24 下午10:18
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem96 {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 示例:
     *
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     *    需要注意的是,不要被1~n这个数字迷惑了,其实不用管其具体数值,刚开始就被这个绕进去了
     *    1~n
     *    可设f[k]为有k个根节点的二插数的个数
     *    设左子树节点个数为k-1,右子树节点个数为n-k
     *    则左子树个数为f[k-i],右子树个数发[n-k+i]
     *    则f[k]=sum(f[k-1]*[n-k]);  0<=i<k
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n<0)return 0;
        if(n<=2)return n;

        int[] flag=new int[n+1];
        flag[0]=1;
        flag[1]=1;
        flag[2]=2;
        for(int i=3;i<=n;i++){
            int tmp=0;
            for(int j=0;j<i;j++){
                tmp=tmp+flag[j]*flag[i-j-1];
            }
            flag[i]=tmp;
        }
        return flag[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem96 problem96 = new Problem96();
        while (scanner.hasNext()) {
            System.out.println(problem96.numTrees(Integer.parseInt(scanner.nextLine().trim())));
        }
        scanner.close();
    }
}
