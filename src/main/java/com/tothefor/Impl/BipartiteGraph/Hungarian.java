package com.tothefor.Impl.BipartiteGraph;

import com.tothefor.ConstEntity.Edge;

import java.util.Arrays;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:10
 * @墨水记忆 www.tothefor.com
 * @Chinese 匈牙利求最大匹配问题
 * @English Hungarian maximum matching problem
 */
public class Hungarian {
    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[] head = new int[indexMax];
    private int[] edgePre = new int[indexMax<<1];
    private int[] edgeTo = new int[indexMax<<1];
    private int[] match = new int[indexMax];
    private boolean[] vis= new boolean[indexMax];
    private int node = 0;

    /**
     * @Chinese 初始化.
     * @English Initialize the.
     * @since Algorithm 1.0
     */
    public void init(int n){
        for(int i=1;i<=n;++i) {
            head[i]=-1;
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
        edgePre[node]=head[a];
        head[a]=node++;
    }

    /**
     * @Chinese 找关系.
     * @English English description.
     * @since Algorithm 1.0
     */
    public boolean find(int x){
        for(int i=head[x];i!=-1;i=edgePre[i]){
            int v = edgeTo[i];
            if(!vis[v]){
                vis[v]=true;
                if(match[v]==0||find(match[v])){
                    match[v] = x;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Chinese 最大匹配.
     * @English To deal with.
     * @since Algorithm 1.0
     */
    public int MMP(int n, Edge[] edges){
        init(n);
        for (int i = 0; i < edges.length; ++i) {
            add_edge(edges[i].begin, edges[i].end, edges[i].weight);
        }

        int ans = 0;
        for(int i=1;i<=n;++i){
            Arrays.fill(vis,false);
            if(find(i)) ans++;
        }
        return ans;
    }

}
