package com.tothefor.Impl.QuickPow;

/**
 * @Author DragonOne
 * @Date 2022/4/20 15:07
 * @墨水记忆 www.tothefor.com
 * @Chinese 快速幂工具类
 * @English Quick power utility class
 */
public final class QuickPow {
    public static long getPow(long  x,long y,long mod) {
        long s=1;
        while(y>0)
        {
            if((y&1)==1) s=(s*x)%mod;
            y>>=1;
            x=(x*x)%mod;
        }
        return s;
    }
}
