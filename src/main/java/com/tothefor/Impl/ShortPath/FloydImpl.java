package com.tothefor.Impl.ShortPath;

import com.tothefor.ConstEntity.Edge;

/**
 * @Author DragonOne
 * @Date 2022/4/20 16:11
 * @墨水记忆 www.tothefor.com
 * @Chinese 多源最短路
 * @English Floyd
 */
public class FloydImpl {
    private int indexMax = 1000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[][] dp = new int[indexMax][indexMax];

    /**
     * @Chinese 初始化.
     * @English init.
     * @since Algorithm 1.0
     */
    public void init(int n){
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                dp[i][j]=INF;
            }
        }
    }

    /**
     * @Chinese 添加关系.
     * @English Add the relationship.
     * @since Algorithm 1.0
     */
    public void add_edge(int a,int b,int c){
        dp[a][b] = Math.min(dp[a][b],c);
    }

    /**
     * @Chinese Floyd.
     * @English Floyd.
     * @since Algorithm 1.0
     */
    public int floyd(int n, int start, int end, Edge[] edges){
        init(n);
        for (int i = 0; i < edges.length; ++i) {
            add_edge(edges[i].begin, edges[i].end, edges[i].weight);
        }
        for(int k=1;k<=n;++k){
            for(int i=1;i<=n;++i){
                for(int j=1;j<=n;++j){
                    if(dp[i][j]>dp[i][k]+dp[k][j]){
                        dp[i][j]=dp[i][k]+dp[k][j];
                    }
                }
            }
        }
        return dp[start][end]==INF? -1:dp[start][end];
    }
    /**
     * @Chinese Floyd.
     * @English Floyd.
     * @since Algorithm 1.0
     */
    public int[][] floyd(int n,Edge[] edges){
        init(n);
        for (int i = 0; i < edges.length; ++i) {
            add_edge(edges[i].begin, edges[i].end, edges[i].weight);
        }
        for(int k=1;k<=n;++k){
            for(int i=1;i<=n;++i){
                for(int j=1;j<=n;++j){
                    if(dp[i][j]>dp[i][k]+dp[k][j]){
                        dp[i][j]=dp[i][k]+dp[k][j];
                    }
                }
            }
        }
        return dp;
    }


}
