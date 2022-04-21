package com.tothefor.Impl.Knapsack;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:45
 * @墨水记忆 www.tothefor.com
 */
public class MultipleBackpack {

    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[] dp = new int[indexMax];
    private int[] w = new int[indexMax];
    private int[] v = new int[indexMax];
    private int g = 1;

    public void init(int n,int m,int[] ww,int[] vv,int[] cc){
        for(int i=1;i<=n;++i){
            int a = ww[i];
            int b = vv[i];
            int c = cc[i];
            for(int j=1;j<=c;j<<=1){
                w[g]=j*a;
                v[g++]=j*b;
                c-=j;
            }
            if(c>0){
                w[g]=c*a;
                v[g++]=c*b;
            }
        }
        for(int i=1;i<=g;++i){
            for(int j=m;j>=w[i];--j){
                dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
    }

    public int MulPack(int n,int m,int[] ww,int[] vv,int[] cc){
        init(n,m,ww,vv,cc);
        return dp[m];
    }


}
