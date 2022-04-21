# AlgorithmModel
A Java-based algorithm template framework。 <br>
一个基于Java的算法模板框架。<br>
此框架简单封装了一些常用算法模板，如：并查集、KMP（字符串匹配）、字典树（Trie）、背包问题、最短路问题、最小生成树问题、快速幂、数组旋转等。<br>
主要目的是用于解决一些简单的现实问题。使用时直接传参调用方法即可。因为主要是用于解决现实的问题，所以内置的数组大小并不大，调用时传入的数组大小不能超过 100000 + 15 。在最短路中数组扩大到了200000 + 15。具体大小可见源码。<br>
使用时，若提供的模板不能满足需求，可自定义Copy源码使用。

# 框架目录

## 内置类
```java
public class Edge {
    public int begin; //边的起点
    public int weight; //边的终点
    public int end; //边的权重
}

```

## 主工具类Algorithm
在主工具类Algorithm中，设置了常用算法方法。直接Algorithm.方法名()即可。对于部分不常用算法，可自行调用对应工具类然后再调用方法即可。
主工具类Algorithm中的方法目录：（无特殊说明，数组下标均从1开始）

> 数学工具类

- gcd(int a,int b)：获取两个数的最大公约数。
- log2(int x)：获取以2为底的x的对数。即log<sub>2</sub><sup>x</sup>。
  
> 数组旋转（顺时针）

- R90(int n, int m, int[][] a)：将n行m列的数组a进行顺时针旋转90°。下标从0开始。下同。
- R180(int n, int m, int[][] a)：180°
- R270(int n, int m, int[][] a)：270°。
  
> 字符串匹配（KMP）

- KMPone(char[] Matching, char[] Pattern)：主串Matching，模式串Pattern。在主串中找是否存在模式串。找到则返回首次匹配的下标，否则返回-1。下同。 
- KMPall(char[] Matching, char[] Pattern)：返回所有匹配的下标。

> 背包问题  

- Pack01(int n, int m, int[] ww, int[] vv)：01背包。n件物品，最大容量m。ww为每件物品的重量，vv为价值。下同。
- ComPack(int n, int m, int[] ww, int[] vv)：完全背包。
- MulPack(int n, int m, int[] ww, int[] vv, int[] cc)：多重背包（二进制优化）

>最小生成树

- MST_Prim(int n, int m, int start, Edge[] edges)：最小生成树Prim算法。n表示点，m表示边。start表示从某个点开始。edges边信息。下同。
- MST_Kruskal(int n, int m, Edge[] edges)：Kruskal算法。

> 最短路

- Dijkstra(int n, int m, int start, int end, Edge[] edges)：最短路Dijkstra算法。n表示点，m表示边。start表示起点，end表示终点。edges表示边信息。下同。
- SPFA(int n, int m, int start, int end, Edge[] edges)：SPFA判断负环，若存在负环则返回-1，否则返货start到end的最短距离。
- Floyd(int n, int start, int end, Edge[] edges)：Floyd。

> 快速幂

- Quick_Pow(long x, long y, long mod)：快速幂。x的y次方再对mod取余。

> 区间最值问题

- RMQ_min(int n, int[] a, int left, int right)：n表示数组a的长度。返回left至right区间中的最小值。下同。
- RMQ_max(int n, int[] a, int left, int right)：最大值。
- RMQ_getMinArr(int n,int[] a)：获取一个二维数组arr\[i\]\[j\]，表示以i为起点，2的j次方为长度的区间中的最小值。下同。
- RMQ_getMaxArr(int n,int[] a)。

> 字典树

- Trie(List<String> list, String str)：给定字符串集合list，查询其中字符串str出现的次数。

> 并查集

- SetCheck(int n,int[] oldFather,int x, int y)：判断两个点是否属性同一集合中。n表示点，oldFather表示点之间的关系，如oldFather\[2\]=3，则表示2的父节点为3。判断x和y是否在同一集合中。
- getDisArr(int n, int[] oldFather,int[] oldDis)：获取每个点到根节点的距离。oldDis表示初始节点到根节点的距离，在初始给定点与点之间的关系时，知道x的父亲是y时，就设置oldDis\[x\]=1即可。最后传入即可。




## 算法详情

### 并查集
实现了三种常用功能：
- 朴素并查集。
- 维护集合大小。
- 维护到根节点距离。

### 字符串匹配（KMP）
实现了两种常用功能：
- 判断是否含有子串，有则返回下标，无则返回-1。
- 查询所有匹配的子串，并返回所有匹配的下标。

### 字典树（Trie）
实现了一种常用功能：
- 查询字符串出现的次数。

### 最短路
主要实现了三种：
- Dijkstra（朴素版和堆优化版）
- SPFA
- Floyd

### 最小生成树
实现了两种：
- Prim
- Kruskal

### RMQ
实现了一种ST方法。

### 快速幂
实现了一种方法。

### 背包问题
- 01背包
- 完全背包
- 多重背包（二进制优化）

### 二分图
- 判断是否为二分图（染色法）
- 求最大匹配问题

### 数组旋转
顺时针旋转：
- 90°
- 180°
- 270°

