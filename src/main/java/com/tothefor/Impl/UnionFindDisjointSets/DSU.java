package com.tothefor.Impl.UnionFindDisjointSets;

/**
 * @Author DragonOne
 * @Date 2022/4/20 13:31
 * @墨水记忆 www.tothefor.com
 */
public final class DSU {

   private static DSUImpl dsUimpl = new DSUImpl();


    /**
     * @Chinese 获取集合数组.
     * @English Get array of collections.
     * @since Algorithm 1.0
     */
    public static int[] getSize(int n, int[] oldFather) {
        return dsUimpl.getSize(n,oldFather);
    }

    /**
     * @Chinese 获取每个节点到根节点的距离数组.
     * @English Gets an array of the distances from each node to the root node.
     * @since Algorithm 1.0
     */
    public static int[] getDis(int n, int[] oldFather,int[] oldDis) {
        return dsUimpl.getDis(n,oldFather,oldDis);
    }

    /**
     * @Chinese 判断两个节点是否属于同一集合.
     * @English Determine whether two nodes belong to the same set.
     * @since Algorithm 1.0
     */
    public static boolean SetCheck(int n,int[] oldFather,int x, int y) {
        return dsUimpl.SetCheck(n,oldFather,x,y);
    }

    /**
     * @Chinese 获取集合总个数.
     * @English Gets the total number of sets.
     * @since Algorithm 1.0
     */
    public static int getSetCnt(int n,int[] oldFather){
        return dsUimpl.getSetCnt(n,oldFather);
    }

}
