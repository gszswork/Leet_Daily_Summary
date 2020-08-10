# 借这道题回忆一下BFS的循环实现，用一个openList就可以
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not TreeNode:
            return True
        openList = []
        openList.append(root)
        openList.append(root)
        while len(openList) != 0:
            e1 = openList.pop(0)
            e2 = openList.pop(0)
            if e1 is None and e1 is None:
                continue
            if e1 is None or e2 is None:
                return False
            if e1.val != e2.val:
                return False
            openList.append(e1.left)
            openList.append(e2.right)
            openList.append(e1.right)
            openList.append(e2.left)

        return True