package com.tothefor.Algorithm;


import com.tothefor.ConstEntity.Edge;
import com.tothefor.Impl.ArrayRotaion.AR;
import com.tothefor.Impl.KMP.KMP;
import com.tothefor.Impl.Knapsack.KN;
import com.tothefor.Impl.MinimumSpanningTree.MST;
import com.tothefor.Impl.QuickPow.QuickPow;
import com.tothefor.Impl.RMQ.RMQ;
import com.tothefor.Impl.ShortPath.ShortPath;
import com.tothefor.Impl.Trie.Trie;
import com.tothefor.Impl.UnionFindDisjointSets.DSU;

import java.util.List;

/**
 * @Author DragonOne
 * @Date 2022/4/20 08:41
 * @墨水记忆 www.tothefor.com
 */
public final class Algorithm {


    private Algorithm() {
    }

    public static final double E = 2.7182818284590452354;
    public static final double PI = 3.14159265358979323846;

    /**
     * @Chinese 求最大公约数.
     * @English Find the greatest common divisor.
     * @since Algorithm 1.0
     */
    public static int gcd(int a, int b) {
        while (b > 0) {
            a %= b;
            b ^= a;
            a ^= b;
            b ^= a;
        }
        return a;
    }

    /**
     * @Chinese 求以2为底的对数.
     * @English Log base two.
     * @since Algorithm 1.0
     */
    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    /**
     * @Chinese 常用数组旋转.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static int[][] R90(int n, int m, int[][] a) {
        return AR.RA90(n, m, a);
    }

    public static int[][] R180(int n, int m, int[][] a) {
        return AR.RA180(n, m, a);
    }

    public static int[][] R270(int n, int m, int[][] a) {
        return AR.RA270(n, m, a);
    }

    /**
     * @Chinese KMP.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static int KMPone(char[] Matching, char[] Pattern) {
        return KMP.getOne(Matching, Pattern);
    }

    public static List<Integer> KMPall(char[] Matching, char[] Pattern) {
        return KMP.getAll(Matching, Pattern);
    }

    /**
     * @Chinese 背包问题.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static int Pack01(int n, int m, int[] ww, int[] vv) {
        return KN.Kn01(n, m, ww, vv);
    }

    public static int ComPack(int n, int m, int[] ww, int[] vv) {
        return KN.ComPack(n, m, ww, vv);
    }

    public static int MulPack(int n, int m, int[] ww, int[] vv, int[] cc) {
        return KN.MulPack(n, m, ww, vv, cc);
    }

    /**
     * @Chinese 最小生成树.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static int MST_Prim(int n, int m, int start, Edge[] edges) {
        return MST.Prim(n, m, start, edges);
    }

    public static int MST_Kruskal(int n, int m, Edge[] edges) {
        return MST.Kruskal(n, m, edges);
    }

    /**
     * @Chinese 最短路问题.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static long Dijkstra(int n, int m, int start, int end, Edge[] edges){
        return ShortPath.getHeapDis(n,m,start,end,edges);
    }
    public static long SPFA(int n, int m, int start, int end, Edge[] edges){
        return ShortPath.SPFA(n,m,start,end,edges);
    }
    public static long Floyd(int n, int start, int end, Edge[] edges){
        return ShortPath.Floyd(n,start,end,edges);
    }


    /**
     * @Chinese 快速幂.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static long Quick_Pow(long x, long y, long mod) {
        return QuickPow.getPow(x, y, mod);
    }

    /**
     * @Chinese 区间最值问题.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static int RMQ_min(int n, int[] a, int left, int right) {
        return RMQ.ST(n, a, left, right, false);
    }

    public static int RMQ_max(int n, int[] a, int left, int right) {
        return RMQ.ST(n, a, left, right, true);
    }
    public static int[][] RMQ_getMinArr(int n,int[] a){
        return RMQ.ST(n,a,false);
    }
    public static int[][] RMQ_getMaxArr(int n,int[] a){
        return RMQ.ST(n,a,true);
    }


    /**
     * @Chinese 字典树.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static int Trie(List<String> list, String str){
        return Trie.QueryStr(list,str);
    }

    /**
     * @Chinese 并查集.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static boolean SetCheck(int n,int[] oldFather,int x, int y){
        return DSU.SetCheck(n,oldFather,x,y);
    }
    public static int getSetSize(int n,int[] oldFather){
        return DSU.getSetCnt(n,oldFather);
    }
    public static int[] getDisArr(int n, int[] oldFather,int[] oldDis){
        return DSU.getDis(n,oldFather,oldDis);
    }


}
