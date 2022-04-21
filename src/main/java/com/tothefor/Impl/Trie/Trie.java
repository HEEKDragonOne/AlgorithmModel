package com.tothefor.Impl.Trie;

import java.util.List;

/**
 * @Author DragonOne
 * @Date 2022/4/20 14:55
 * @墨水记忆 www.tothefor.com
 * @Chinese 字典树工具类
 * @English Dictionary tree utility class
 */
public final class Trie {

    private static TrieImpl trie = new TrieImpl();

    /**
     * @Chinese 查询字符串出现次数.
     * @English Number of occurrences of a query string.
     * @since Algorithm 1.0
     */
    public static int QueryStr(List<String> list, String str){
        return trie.query(list,str);
    }

}
