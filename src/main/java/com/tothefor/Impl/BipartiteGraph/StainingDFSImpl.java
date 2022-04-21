package com.tothefor.Impl.BipartiteGraph;

import com.tothefor.ConstEntity.Edge;
import lombok.Builder;

import java.lang.annotation.Annotation;

/**
 * @Author DragonOne
 * @Date 2022/4/21 14:54
 * @墨水记忆 www.tothefor.com
 * @Chinese 染色法dfs实现
 * @English DFS dyeing method to achieve
 */
public class StainingDFSImpl {
    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[] head = new int[indexMax];
    private int[] edgePre = new int[indexMax<<1];
    private int[] edgeTo = new int[indexMax<<1];
    private boolean[] vis= new boolean[indexMax];
    public int[] color = new int[indexMax];
    private int node = 0;

    /**
     * @Chinese 初始化.
     * @English Initialize the.
     * @since Algorithm 1.0
     */
    public void init(int n){
        for(int i=1;i<=n;++i) {
            head[i]=-1;
            color[i]=0;
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
     * @Chinese 染色处理.
     * @English The dyeing process.
     * @since Algorithm 1.0
     */
    public boolean dfs(int u,int c){
        color[u] = c;
        for(int i=head[u];i!=-1;i=edgePre[i]){
            int v = edgeTo[i];
            if(color[v]==0){
                if(!dfs(v,3-c)){
                    return false;
                }
            }else if(color[v]==c){
                return false;
            }
        }
        return true;
    }

    /**
     * @Chinese 不确定是否连通.
     * @English Not sure if it's connected.
     * @since Algorithm 1.0
     */
    public boolean mk(int n){
        boolean flag = true;
        for(int i=1;i<=n;++i){
            if(color[i]==0){
                if(!dfs(i,1)){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * @Chinese 染色法判断是否为二分图.
     * @English The dichotomous graph is judged by staining.
     * @since Algorithm 1.0
     */
    public boolean Staining(int n,Edge[] edges,boolean flag){
        boolean ansFlag = false;
        init(n);
        for (int i = 0; i < edges.length; ++i) {
            add_edge(edges[i].begin, edges[i].end, edges[i].weight);
        }
        if(flag){
            ansFlag = dfs(1,1);
        }else{
             ansFlag = mk(n);
        }

        return ansFlag;
    }

}
