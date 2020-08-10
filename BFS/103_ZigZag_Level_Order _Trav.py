from _ast import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# 一个简单的题目，要求将二叉树的每一层，正序倒序交叉保存在列表里。
# 宽度优先搜索，并且维持一个order的变量，在openList中也保存一个标记当前节点是属于正序列还是倒序列的变量。
# 当搜索到当前节点与order不一致时，就改变order的值，scan完一层以后，会发现openList下一个元素的序列与当前不一致，就把所有当前列表保存
# 并清空。

# 问题：LIST.reverse()函数会将LIST翻转，本身却不返回任何东西。如果用了res.append(LIST.reverse())就会出现错误,正确为：
# List.reverse()
# res.append(LIST)

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root:
            return res
        openList = []
        openList.append([root, True])
        res.append([root.val])
        order = True
        innerRes = []
        while len(openList) != 0:
            t = openList[0]
            #print(t[0].val, " ", t[1], " oder:", order)
            if order == t[1]:
                # innerRes.append(t[0].val)
                openList.pop(0)
            else:
                order = not order
                continue
            if t[0].left:
                openList.append([t[0].left, not t[1]])
                innerRes.append(t[0].left.val)
            if t[0].right:
                openList.append([t[0].right, not t[1]])
                innerRes.append(t[0].right.val)
            if len(openList) and order != openList[0][1]:
                # add innerRes to res
                if order:
                    innerRes.reverse()
                    #print(innerRes)
                    res.append(innerRes)
                    innerRes = []
                else:
                    res.append(innerRes)
                    innerRes = []
        if len(innerRes):
            if order:
                res.append(innerRes)
            else:
                innerRes.reverse()
                res.append(innerRes)

        return res