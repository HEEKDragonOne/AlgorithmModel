package com.tothefor.Impl.ArrayRotaion;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:52
 * @墨水记忆 www.tothefor.com
 */
public class AR {

    private static ARImpl ar = new ARImpl();

    public static int[][] RA90(int n,int m,int[][] a){
        return ar.Ra90(n,m,a);
    }
    public static int[][] RA180(int n,int m,int[][] a){
        return ar.Ra180(n,m,a);
    }
    public static int[][] RA270(int n,int m,int[][] a){
        return ar.Ra270(n,m,a);
    }
}
