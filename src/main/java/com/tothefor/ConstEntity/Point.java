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
    public int weight;
    public Point(int point, int weight) {
        this.point = point;
        this.weight = weight;
    }
    @Override
    public int compareTo(Point obj) {
        return this.weight - obj.weight;
    }
}
