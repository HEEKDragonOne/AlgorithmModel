package com.tothefor.Impl.ShortPath;

import com.tothefor.ConstEntity.Edge;
import com.tothefor.ConstEntity.Point;

import java.util.PriorityQueue;

/**
 * @Author DragonOne
 * @Date 2022/4/20 15:32
 * @墨水记忆 www.tothefor.com
 * @Chinese 堆优化版Dijkstra
 * @English Heap optimized version of Dijkstra
 */
public class DijkstraHeapImpl {

    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[] dis = new int[indexMax];
    private int[] head = new int[indexMax];
    private int[] edgePre = new int[indexMax<<1];
    private int[] edgeW = new int[indexMax<<1];
    private int[] edgeTo = new int[indexMax<<1];
    private boolean[] vis= new boolean[indexMax];
    private Edge[] edges = new Edge[indexMax<<1];
    private int node = 0;

    /**
     * @Chinese 初始化.
     * @English Initialize the.
     * @since Algorithm 1.0
     */
    public void init(int n,int m){
        for(int i=0;i<=m;++i) {
            edges[i] = new Edge();
        }
        for(int i=1;i<=n;++i) {
            dis[i] = INF;
            head[i]=-1;
            vis[i]=false;
        }
        node=0;
    }

    /**
     * @Chinese 添加边.
     * @English Add edge.
     * @since Algorithm 1.0
     */
    public void add_edge(int a,int b,int c){
        edgeTo[node]=b;
        edgeW[node]=c;
        edgePre[node]=head[a];
        head[a]=node++;
    }

    public long Dijkstra(int n,int m,int start,int end,Edge[] edges) {
        init(n, m);
        for (int i = 0; i < edges.length; ++i) {
            add_edge(edges[i].begin, edges[i].end, edges[i].weight);
        }

        PriorityQueue<Point> q = new PriorityQueue<Point>();
        q.add(new Point(start,0));
        dis[start] = 0;
        while(!q.isEmpty()) {
            int u = q.poll().point;
            if(vis[u] == true) continue;
            vis[u] = true;
            for(int i = head[u]; i!=-1; i=edgePre[i]) {
                int to = edgeTo[i];
                if(dis[to] > dis[u] + edgeW[i]) {
                    dis[to] = dis[u] + edgeW[i];
                    q.add(new Point(to, dis[to]));
                }
            }
        }
        if(dis[end]==INF) return -1;
        else return dis[end];
    }

}
