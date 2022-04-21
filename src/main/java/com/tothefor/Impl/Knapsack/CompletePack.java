package com.tothefor.Impl.Knapsack;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:41
 * @墨水记忆 www.tothefor.com
 * 完全背包
 */
public class CompletePack {
    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[] dp = new int[indexMax];
    private int[] w = new int[indexMax];
    private int[] v = new int[indexMax];

    /**
     * @Chinese 完全背包处理.
     * @English English description.
     * @since Algorithm 1.0
     */
    public void init(int n,int m){
        for(int i=1;i<=n;++i){
            for(int j=w[i];j<=m;++j){ //与01背包的区别
                dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
    }

    /**
     * @Chinese 完全背包.
     * @English English description.
     * @since Algorithm 1.0
     */
    public int CompPack(int n,int m,int[] ww,int[] vv){
        for(int i=1;i<=n;++i) {
            w[i] = ww[i];
            v[i] = vv[i];
        }
        init(n,m);
        return dp[m];
    }


}
