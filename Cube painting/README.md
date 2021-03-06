## 骰子涂色（Cube Painting)
 
一个骰子有六个面，用三种颜色来涂色（红，蓝，绿），由于涂色的顺序不一致，导致每两个骰子可能不是完全一致的。如果一个骰子可以通过翻转多次的方式与另一个骰子涂色一致，那就定义这两个骰子是一样的，

给出一个方法判断两个骰子是否一样。


![](https://github.com/gszswork/Leet_Daily_Summary/blob/master/Cube%20painting/ima/cube1.png)
![](https://github.com/gszswork/Leet_Daily_Summary/blob/master/Cube%20painting/ima/cube2.png)
![](https://github.com/gszswork/Leet_Daily_Summary/blob/master/Cube%20painting/ima/cube3.png)


### 思路：将一枚骰子保持不变，翻转另外一个看是否能达到一致。

对骰子上、下、左、右、前、后进行编号1、2、3、4、5、6。 旋转时，每个面都有可能朝上（1），一共有6种可能，当1的位置被确定了，2的位置也确定。接下来就左右旋转切换2，3，4，5的位置。旋转的过程中一共有四种可能，如图：
![](https://github.com/gszswork/Leet_Daily_Summary/blob/master/Cube%20painting/ima/cube4.jpg)

变换的方式为:
s2[1]=s1[1], s2[2]=s1[2], 
s2[3]=s1[5], s2[4]=s1[6], s2[5]=s1[4], s2[6]=s1[3]


## 代码解法：
暴力枚举，cube矩阵中列出了一个骰子所有不同摆法的索引

1. 在sameCube中，使用cmp来代表b，将cmp设置不同的上下面并不停翻转查看是否与a吻合

2. 利用sameString函数判断，如果吻合则返回true, 否则在sameCube函数最后返回false 

*代码实现采用了骰子中1-6实际的索引，上下左右前后为162453*
