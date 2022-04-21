package com.tothefor.ConstEntity;

/**
 * @Author DragonOne
 * @Date 2022/4/20 15:24
 * @墨水记忆 www.tothefor.com
 * @Chinese 存储点信息的类
 * @English Memory point information class
 */
public class Point implements Comparable<Point>{
    public int point;
    public int disBegin;
    public Point(int point, int disBegin) {
        this.point = point;
        this.disBegin = disBegin;
    }
    @Override
    public int compareTo(Point obj) {
        return this.disBegin - obj.disBegin;
    }
}
