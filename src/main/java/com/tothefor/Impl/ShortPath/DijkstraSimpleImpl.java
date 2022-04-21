package com.tothefor.Impl.ShortPath;

import com.tothefor.ConstEntity.Edge;

/**
 * @Author DragonOne
 * @Date 2022/4/20 15:10
 * @墨水记忆 www.tothefor.com
 * @Chinese 朴素版Dijkstra
 * @English Simple version of Dijkstra
 */
public final class DijkstraSimpleImpl {

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

    /**
     * @Chinese 计算最短路.
     * @English Calculated shortest circuit.
     * @since Algorithm 1.0
     */
    public long Dijkstra(int n,int m,int start,int end,Edge[] edges){
        init(n,m);
        for(int i=0;i<edges.length;++i){
            add_edge(edges[i].begin,edges[i].end,edges[i].weight);
        }

        dis[start] = 0;
        for(int i=1;i<=n;++i){
            int t = -1;
            for(int j=1;j<=n;++j){
                if( !vis[j] && ( t==-1 || dis[t]>dis[j] ) ) {
                    t = j;
                }
            }
            vis[t] = true;
            for(int j=head[t];j!=-1;j=edgePre[j]){
                int to = edgeTo[j];
                dis[to]=Math.min(dis[to],dis[t]+edgeW[j]);
            }
        }
        if(dis[end]==INF) return -1;
        else return dis[end];
    }


}
