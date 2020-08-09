## DFS暴力搜索
 
N个数字，扔掉任意个，然后把剩下的拆分成两组和（SUM）相同的数，问扔掉的数的和的最小值是多少。


### 思路：将数字分为三个部分，左 l， 右 r， 丢弃drop。用DFS枚举所有的分布可能，并且在枚举过程中记录drop的最小值。




## 代码解法：
```
ret = MAX_INT_VALUE
void dfs(int id, int l, int r, int drop){
if ( id == length + 1 ){          //If the deep first search ends
if ( l == r){
ret = min( ret, drop )
}
return
}
dfs( id+1, l + a[id], r, drop );    //current item a[id] separate to l
dfs( id+1, l, r + a[id], drop ); //current item a[id] separate to r
dfs( id+1, l, r, drop + a[id] ); //current item a[id] separate to drop
}

```

该dfs会搜索所有可能的结果，每种搜索结束后，如果drop的值小于ret，就更新ret，这样最后返回的ret的值就是最小的。
