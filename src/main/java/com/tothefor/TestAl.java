package com.tothefor;


import com.tothefor.Impl.Trie.Trie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author DragonOne
 * @Date 2022/4/19 23:32
 * @墨水记忆 www.tothefor.com
 */
public class TestAl {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);

    final static int maxn = (int) 1e7 + 6;
    public static int[][] son = new int[maxn][26]; //存储树中每个节点的子节点
    public static int idx = 0; //0号点既是根节点，又是空节点
    public static int[] cnt = new int[maxn]; //存储以每个节点结尾的单词数量

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int n = sc.nextInt();
        while (n-- != 0) {
            String s = sc.next();
            list.add(s);
        }
        String str = sc.next();
        System.out.println(Trie.QueryStr(list, str));

    }

}
