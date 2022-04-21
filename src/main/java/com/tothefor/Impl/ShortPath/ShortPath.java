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
    private static SPFAImpl spfa = new SPFAImpl();
    private static FloydImpl floyd = new FloydImpl();

    /**
     * @Chinese 朴素版Dijkstra.
     * @English Simple version of Dijkstra.
     * @since Algorithm 1.0
     */
    public static long getSimpleDis(int n, int m, int start, int end, Edge[] edges) {
        return dijkstraSimple.Dijkstra(n, m, start, end, edges);
    }

    /**
     * @Chinese 堆优化版Dijkstra.
     * @English Heap optimized version of Dijkstra.
     * @since Algorithm 1.0
     */
    public static long getHeapDis(int n, int m, int start, int end, Edge[] edges) {
        return dijkstraHeap.Dijkstra(n, m, start, end, edges);
    }

    /**
     * @Chinese SPFA判断负环和求最短路，存在负环则返回-1，否则返回最短路.
     * @English SPFA determines the negative loop and calculates the shortest circuit.
     * If there is a negative loop, -1 is returned; otherwise, the shortest circuit is returned.
     * @since Algorithm 1.0
     */
    public static int SPFA(int n, int m, int start, int end, Edge[] edges) {
        return spfa.SPFA(n, m, start, end, edges);
    }

    /**
     * @Chinese Floyd求指定两点的最短距离.
     * @English Floyd finds the shortest distance between a given two points.
     * @since Algorithm 1.0
     */
    public static int[][] Floyd(int n, Edge[] edges) {
        return floyd.floyd(n, edges);
    }

    /**
     * @Chinese Floyd求所有点之间的距离，并返回距离数组.
     * @English Floyd finds the distance between all points and returns an array of distances.
     * @since Algorithm 1.0
     */
    public static int Floyd(int n, int start, int end, Edge[] edges) {
        return floyd.floyd(n, start, end, edges);
    }


}
