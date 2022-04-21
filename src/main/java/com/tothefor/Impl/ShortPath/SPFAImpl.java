package com.tothefor.Impl.ShortPath;

import com.tothefor.ConstEntity.Edge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author DragonOne
 * @Date 2022/4/20 16:05
 * @墨水记忆 www.tothefor.com
 * @Chinese SPFA
 * @English SPFA
 */
public class SPFAImpl {

    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[] dis = new int[indexMax];
    private int[] head = new int[indexMax];
    private int[] edgePre = new int[indexMax<<1];
    private int[] edgeW = new int[indexMax<<1];
    private int[] edgeTo = new int[indexMax<<1];
    private boolean[] vis= new boolean[indexMax];
    private int[] num = new int[indexMax];
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
     * @Chinese 判断负环和输出距离.
     * @English Determine the negative loop and output distance.
     * @since Algorithm 1.0
     */
    public int SPFA(int n,int m,int start,int end,Edge[] edges){
        init(n, m);
        for (int i = 0; i < edges.length; ++i) {
            add_edge(edges[i].begin, edges[i].end, edges[i].weight);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        dis[start]=0;
        num[start]=1;
        vis[start]=true;
        while (!q.isEmpty()){
            int u = q.poll();
            vis[u]=false;
            for(int i = head[u];i!=-1;i=edgePre[i]){
                int v = edgeTo[i];
                if(dis[v]<=dis[u]+edgeW[i]) continue;
                dis[v]=dis[u]+edgeW[i];
                num[v]=num[u]+1;
                if(num[v]>m){
                    return -1;
                }
                if (!vis[v]){
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return dis[end];
    }



}
