package com.tothefor.Impl.BipartiteGraph;

import com.tothefor.ConstEntity.Edge;

import java.lang.annotation.Annotation;

/**
 * @Author DragonOne
 * @Date 2022/4/21 14:52
 * @墨水记忆 www.tothefor.com
 * @Chinese 二分图工具类
 * @English DFS dyeing method to achieve
 */
public class BG {
    private static StainingDFSImpl stainingDFS = new StainingDFSImpl();
    private static Hungarian hungarian = new Hungarian();

    /**
     * @Chinese 二分图判断.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static boolean Staining(int n, Edge[] edges, boolean flag){
        return stainingDFS.Staining(n,edges,flag);
    }

    /**
     * @Chinese 最大匹配.
     * @English English description.
     * @since Algorithm 1.0
     */
    public static int MMP(int n,Edge[] edges){
        return hungarian.MMP(n,edges);
    }
}
