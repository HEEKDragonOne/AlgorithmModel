package com.tothefor.Impl.ArrayRotaion;

/**
 * @Author DragonOne
 * @Date 2022/4/21 15:52
 * @墨水记忆 www.tothefor.com
 */
public class ARImpl {

    private int indexMax = 200000 + 15;
    private int[][] b = new int[indexMax][indexMax];

    /**
     * @Chinese 90°.
     * @English English description.
     * @since Algorithm 1.0
     */
    public void init90(int n,int m,int[][] a){
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                b[i][j]=a[n-1-j][i];
            }
        }
    }

    /**
     * @Chinese 180°.
     * @English English description.
     * @since Algorithm 1.0
     */
    public void init180(int n,int m,int[][] a){
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                b[i][j]=a[n-1-i][m-1-j];
            }
        }
    }

    /**
     * @Chinese 270°.
     * @English English description.
     * @since Algorithm 1.0
     */
    public void init270(int n,int m,int[][] a){
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                b[i][j]=a[j][m-1-i];
            }
        }
    }

    public int[][] Ra90(int n,int m,int[][] a){
        init90(n,m,a);
        return b;
    }
    public int[][] Ra180(int n,int m,int[][] a){
        init180(n,m,a);
        return b;
    }
    public int[][] Ra270(int n,int m,int[][] a){
        init270(n,m,a);
        return b;
    }
}
