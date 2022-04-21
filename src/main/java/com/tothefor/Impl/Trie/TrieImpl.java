package com.tothefor.Impl.Trie;

import java.util.List;

/**
 * @Author DragonOne
 * @Date 2022/4/20 14:37
 * @墨水记忆 www.tothefor.com
 * @Chinese 字典树工具类
 * @English Dictionary tree utility class
 */
public class TrieImpl {

    private static int indexMax = 100000 + 15;
    private static int[][] son = new int[indexMax][26]; //存储树中每个节点的子节点 The children of each node in the storage tree
    private static int idx = 0; //0号点既是根节点，又是空节点
    private static int[] cnt = new int[indexMax]; //存储以每个节点结尾的单词数量 Stores the number of words ending in each node


    /**
     * @Chinese 插入字符串.
     * @English Insert string.
     * @since Algorithm 1.0
     */
    public void insert(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; ++i) {
            int v = str[i] - 'a';
            if (son[p][v] == 0) son[p][v] = ++idx;
            p = son[p][v];
        }
        cnt[p]++;
    }

    /**
     * @Chinese 查询字符串出现的次数.
     * @English The number of occurrences of the query string.
     * @since Algorithm 1.0
     */
    public int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; ++i) {
            int v = str[i] - 'a';
            if (son[p][v] == 0) return 0;
            p = son[p][v];
        }
        return cnt[p];
    }

    /**
     * @Chinese 查询并返回数据.
     * @English Query and return data.
     * @since Algorithm 1.0
     */
    public int query(List<String> list,String str){
        for(int i=0;i<list.size();++i){
            char[] ch = list.get(i).toCharArray();
            insert(ch);
        }
        return query(str.toCharArray());
    }

}
