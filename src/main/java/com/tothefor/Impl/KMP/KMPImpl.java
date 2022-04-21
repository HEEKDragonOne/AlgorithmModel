package com.tothefor.Impl.KMP;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DragonOne
 * @Date 2022/4/20 14:14
 * @墨水记忆 www.tothefor.com
 * @Chinese 字符串匹配KMP工具类
 * @English The string matches the KMP utility class
 */
public final class KMPImpl {
    private int indexMax = 100000 + 15;
    private int[] ne = new int[indexMax];

    /**
     * @Chinese 获取next数组.
     * @English Get the Next array.
     * @since Algorithm 1.0
     */
    public void getnext(char[] Pattern) {
        ne[0] = -1;
        int len = Pattern.length;
        int i = 0, j = -1;
        while (i < len-1) {
            if (j == -1 || Pattern[i] == Pattern[j]) {
                ne[++i] = ++j;
            } else j = ne[j];
        }
    }

    /**
     * @Chinese kmp单次匹配.
     * @English KMP single match.
     * @since Algorithm 1.0
     */
    public int getOne(char[] Matching, char[] Pattern) {
        getnext(Pattern);
        int xlen = Matching.length;
        int ylen = Pattern.length;
        int i = 0, j = 0;
        while (i < xlen && j < ylen) {
            if (j == -1 || Matching[i] == Pattern[j]) {
                i++;
                j++;
            } else
                j = ne[j];
        }
        if (j == ylen)
            return i-ylen;
        else
            return -1;
    }

    /**
     * @Chinese 获取所有匹配.
     * @English Get all matches.
     * @since Algorithm 1.0
     */
    public List<Integer> getAll(char[] Matching, char[] Pattern) {
        List<Integer> list = new ArrayList<>();
        getnext(Pattern);
        int xlen = Matching.length;
        int ylen = Pattern.length;
        int i = 0, j = 0;
        while (i < xlen && j < ylen) {
            if (j == -1 || Matching[i] == Pattern[j]) {
                i++;
                j++;
                if (j == ylen) {
                    list.add(i-j);
                    j = ne[j];
                }
            } else j = ne[j];
        }
        return list;
    }

}
