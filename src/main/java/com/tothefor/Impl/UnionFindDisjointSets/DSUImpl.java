package com.tothefor.Impl.UnionFindDisjointSets;


/**
 * @Author DragonOne
 * @Date 2022/4/20 09:34
 * @墨水记忆 www.tothefor.com
 * @Chinese 并查集工具类
 * @English Union Find Disjoint Sets Tools
 */
public final class DSUImpl {

    private int node = 1;
    private int indexMax = 100000 + 15;
    private int[] father = new int[indexMax];
    private int[] size = new int[indexMax];
    private int[] dis = new int[indexMax];

    /**
     * @Chinese 并查集初始化.
     * @English And lookup set initialization.
     * @since Algorithm 1.0
     */
    public void init(int n) {
        for (int i = node; i <= n; ++i) {
            father[i] = i;
            size[i] = 1;
            dis[i] = 0;
        }
    }

    /**
     * @Chinese 并查集查找并路径压缩.
     * @English And look up the set to find and path compression.
     * @since Algorithm 1.0
     */
    public int find(int x) {
        if (father[x] != x) {
            int t = father[x];
            father[x] = find(father[x]);
            dis[x] += dis[t];
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
            size[ty] += size[tx];
        }
    }

    /**
     * @Chinese 逻辑处理.
     * @English Logical processing.
     * @since Algorithm 1.0
     */
    public void Deal(int n, int[] oldFather) {
        init(n);
        for(int i=node;i<=n;++i) father[i] = oldFather[i];
        for (int i = node; i <= n; ++i) {
            merge(i, father[i]);
        }
    }
    /**
     * @Chinese 逻辑处理.
     * @English Logical processing.
     * @since Algorithm 1.0
     */
    public void Deal(int n, int[] oldFather,int[] oldDis) {
        init(n);
        for (int i = node; i <= n; ++i) {
            father[i] = oldFather[i];
            dis[i] = oldDis[i];
        }
        for(int i=node;i<=n;++i){
            find(i);
        }
    }

    /**
     * @Chinese 获取集合数组.
     * @English Get array of collections.
     * @since Algorithm 1.0
     */
    public int[] getSize(int n, int[] oldFather) {
        Deal(n, oldFather);
        return size;
    }

    /**
     * @Chinese 获取每个节点到根节点的距离数组.
     * @English Gets an array of the distances from each node to the root node.
     * @since Algorithm 1.0
     */
    public int[] getDis(int n, int[] oldFather,int[] oldDis) {
        Deal(n, oldFather,oldDis);
        return dis;
    }

    /**
     * @Chinese 判断两个节点是否属于同一集合.
     * @English Determine whether two nodes belong to the same set.
     * @since Algorithm 1.0
     */
    public boolean SetCheck(int n,int[] oldFather,int x,int y) {
        Deal(n,oldFather);
        return find(x) == find(y) ? true : false;
    }

    /**
     * @Chinese 获取集合总个数.
     * @English Gets the total number of sets.
     * @since Algorithm 1.0
     */
    public int getSetCnt(int n,int[] oldFather){
        Deal(n, oldFather);
        int cnt = 0;
        for(int i=node;i<=n;++i){
            if(father[i]==i) cnt++;
        }
        return cnt;
    }





}
