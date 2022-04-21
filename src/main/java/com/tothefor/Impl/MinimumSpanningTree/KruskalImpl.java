package com.tothefor.Impl.MinimumSpanningTree;

import com.tothefor.ConstEntity.Edge;

import java.util.Arrays;

/**
 * @Author DragonOne
 * @Date 2022/4/21 14:28
 * @墨水记忆 www.tothefor.com
 * @Chinese Kruskal
 * @English Kruskal
 */
public class KruskalImpl {
    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[] father = new int[indexMax];

    /**
     * @Chinese 初始化.
     * @English init.
     * @since Algorithm 1.0
     */
    public void init(int n){
        for (int i = 1; i <= n; ++i) {
            father[i] = i;
        }
    }
    /**
     * @Chinese 并查集查找并路径压缩.
     * @English And look up the set to find and path compression.
     * @since Algorithm 1.0
     */
    public int find(int x) {
        if (father[x] != x) {
            father[x]=find(father[x]);
        }
        return father[x];
    }
    /**
     * @Chinese 合并两个节点所在的集合.
     * @English Merges the collection of two nodes.
     * @since Algorithm 1.0
     */
    public void merge(int x, int y) { // y -> x
        int tx = find(x);
        int ty = find(y);
        if (tx != ty) {
            father[tx] = ty;
        }
    }

    /**
     * @Chinese Kruskal.
     * @English Kruskal.
     * @since Algorithm 1.0
     */
    public int Kruskal(int n,int m, Edge[] edges){
        init(n);
        int res = 0;
        int cnt = 0;
        Arrays.sort(edges,1,m+1);
        for(int i=1;i<=m;++i){
            int u = edges[i].begin;
            int v = edges[i].end;
            int w = edges[i].weight;
            if(find(u)!=find(v)){
                merge(u,v);
                res+=w;
                cnt++;
            }
        }
        if(cnt<n-1) return -1;
        else return res;
    }
}
