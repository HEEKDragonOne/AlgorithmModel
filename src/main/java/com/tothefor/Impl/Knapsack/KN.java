package com.tothefor.Impl.Knapsack;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:39
 * @墨水记忆 www.tothefor.com
 * 背包问题
 */
public class KN {

    private static Knapsack01 knapsack01 = new Knapsack01();
    private static CompletePack completePack = new CompletePack();
    private static MultipleBackpack multipleBackpack = new MultipleBackpack();

    public static int Kn01(int n,int m,int[] ww,int[] vv){
        return knapsack01.BB01(n,m,ww,vv);
    }
    public static int ComPack(int n,int m,int[] ww,int[] vv){
        return completePack.CompPack(n,m,ww,vv);
    }
    public static int MulPack(int n,int m,int[] ww,int[] vv,int[] cc){
        return multipleBackpack.MulPack(n,m,ww,vv,cc);
    }

}
