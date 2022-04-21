package com.tothefor.Impl.RMQ;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:22
 * @墨水记忆 www.tothefor.com
 * @Chinese RMQ
 * @English RMQ
 */
public class RMQ {

    private static STImpl st = new STImpl();

    public static int ST(int n,int[] a,int left,int right,boolean flag){
        return st.ST(n,a,left,right,flag);
    }

    public static int[][] ST(int n,int[] a,boolean flag){
        return st.ST(n,a,flag);
    }

}
