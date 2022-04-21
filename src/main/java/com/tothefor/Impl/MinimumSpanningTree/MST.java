package com.tothefor.Impl.MinimumSpanningTree;

import com.tothefor.ConstEntity.Edge;

/**
 * @Author DragonOne
 * @Date 2022/4/21 14:27
 * @墨水记忆 www.tothefor.com
 * @Chinese 最小生成树工具类
 * @English Minimum Spanning Tree
 */
public class MST {

    private static PrimImpl prim = new PrimImpl();
    private static KruskalImpl kruskal = new KruskalImpl();

    /**
     * @Chinese Prim.
     * @English Prim.
     * @since Algorithm 1.0
     */
    public static int Prim(int n, int m, int start, Edge[] edges){
        return prim.Prim(n,m,start,edges);
    }

    /**
     * @Chinese Kruskal.
     * @English Kruskal.
     * @since Algorithm 1.0
     */
    public static int Kruskal(int n,int m, Edge[] edges){
        return kruskal.Kruskal(n,m,edges);
    }
}
