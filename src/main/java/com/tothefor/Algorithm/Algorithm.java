package com.tothefor.Algorithm;


/**
 * @Author DragonOne
 * @Date 2022/4/20 08:41
 * @墨水记忆 www.tothefor.com
 */
public final class Algorithm {



    private Algorithm() {}
    public static final double E = 2.7182818284590452354;
    public static final double PI = 3.14159265358979323846;

    /**
     * @Chinese 求最大公约数.
     * @English Find the greatest common divisor.
     * @since Algorithm 1.0
     */
    public static int gcd(int a,int b){
        while (b > 0) {
            a %= b;
            b ^= a;
            a ^= b;
            b ^= a;
        }
        return a;
    }

    /**
     * @Chinese 求以2为底的对数.
     * @English Log base two.
     * @since Algorithm 1.0
     */
    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

}
