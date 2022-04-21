package com.tothefor.Impl.RMQ;

import com.tothefor.Algorithm.Algorithm;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:22
 * @墨水记忆 www.tothefor.com
 * @Chinese ST
 * @English ST
 */
public class STImpl {

    private int indexMax = 200000 + 15;
    private int INF = 0x3f3f3f3f;
    private int[][] minData = new int[indexMax][110];
    private int[][] maxData = new int[indexMax][110];

    /**
     * @Chinese 预处理.
     * @English English description.
     * @since Algorithm 1.0
     */
    public void getST(int n,int[] a){
        for(int i=1;i<=n;++i){
            minData[i][0]=a[i];
            maxData[i][0]=a[i];
        }
        for(int j = 1; j<= Algorithm.log2(n); ++j){
            for(int i= 1; i+(1<<j)-1<=n;++i){
                minData[i][j]=Math.min(minData[i][j-1],minData[i+(1<<(j-1))][j-1]);
                maxData[i][j]=Math.max(maxData[i][j-1],maxData[i+(1<<(j-1))][j-1]);
            }
        }
    }

    /**
     * @Chinese 区间最小值.
     * @English English description.
     * @since Algorithm 1.0
     */
    public int ST_minQuery(int l,int r ){
        int t = Algorithm.log2(r-l+1);
        return Math.min(minData[l][t],minData[r-(1<<t)+1][t]);
    }

    /**
     * @Chinese 区间最大值.
     * @English English description.
     * @since Algorithm 1.0
     */
    public int ST_maxQuery(int l,int r ){
        int t = Algorithm.log2(r-l+1);
        return Math.max(maxData[l][t],maxData[r-(1<<t)+1][t]);
    }

    /**
     * @Chinese 获取区间最值数组.
     * @English English description.
     * @since Algorithm 1.0
     */
    public int[][] ST(int n,int[] a,boolean flag){
        getST(n,a);
        if(flag) return maxData;
        else return minData;
    }

    /**
     * @Chinese 获取某个区间的最值.
     * @English English description.
     * @since Algorithm 1.0
     */
    public int ST(int n,int[] a,int left,int right,boolean flag){
        getST(n,a);
        if(flag){
            return ST_maxQuery(left,right);
        }else{
            return ST_minQuery(left,right);
        }
    }


}
