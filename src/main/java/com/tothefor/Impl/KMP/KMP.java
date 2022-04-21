package com.tothefor.Impl.KMP;

import java.util.List;

/**
 * @Author DragonOne
 * @Date 2022/4/20 14:31
 * @墨水记忆 www.tothefor.com
 */
public final class KMP {

    private static KMPImpl kmp = new KMPImpl();

    /**
     * @Chinese 查询是否含有子串，有则返回下标；无则返回-1.Matching表示主串，Pattern表示模式串.
     * @English Query whether there are substrings, if there are substrings return subscripts;
     * If no, return -1.Matching indicates the main string, and Pattern indicates the Pattern string.
     * @since Algorithm 1.0
     */
    public static int getOne(char[] Matching, char[] Pattern){
        return kmp.getOne(Matching,Pattern);
    }

    public static List<Integer> getAll(char[] Matching, char[] Pattern){
        return kmp.getAll(Matching,Pattern);
    }

}
