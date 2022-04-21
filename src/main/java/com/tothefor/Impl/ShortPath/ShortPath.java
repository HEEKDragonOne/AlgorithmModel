package com.tothefor.Impl.ShortPath;

import com.tothefor.ConstEntity.Edge;

/**
 * @Author DragonOne
 * @Date 2022/4/20 15:10
 * @墨水记忆 www.tothefor.com
 * @Chinese 最短路工具类
 * @English Most short circuit tool class
 */
public final class ShortPath {

    private static DijkstraSimpleImpl dijkstraSimple = new DijkstraSimpleImpl();
    private static DijkstraHeapImpl dijkstraHeap = new DijkstraHeapImpl();

    /**
     * @Chinese 朴素版Dijkstra.
     * @English Simple version of Dijkstra.
     * @since Algorithm 1.0
     */
    public static long getSimpleDis(int n, int m, int start, int end, Edge[] edges){
        return dijkstraSimple.Dijkstra(n,m,start,end,edges);
    }

    /**
     * @Chinese 堆优化版Dijkstra.
     * @English Heap optimized version of Dijkstra.
     * @since Algorithm 1.0
     */
    public static long getHeapDis(int n,int m,int start,int end,Edge[] edges){
        return dijkstraHeap.Dijkstra(n,m,start,end,edges);
    }

}
