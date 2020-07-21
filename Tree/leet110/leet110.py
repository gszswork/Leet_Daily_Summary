# Definition for a binary tree node.
from _ast import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        res = [], count = []
        self.dfsHelper(root, 0, res, count)
        return res / count

    def dfsHelper(self, root, h, res, count):
        if root:
            res[h] += root.val
            count[h] += 1
        if root.left:
            self.dfsHelper(root.left, h + 1, res, count)
        if root.right:
            self.dfsHelper(root.right, h + 1, res, count)