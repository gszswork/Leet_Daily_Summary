class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# 水题，找树的最小深度，也就是找从根节点到最近的叶子节点的举例
# BFS找到叶子节点后直接return当前叶子节点的深度即可

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        queue = []
        queue.append((root, 1))
        while len(queue) > 0:
            node, depth = queue.pop(0)
            if not node.left and not node.right:
                return depth
            else:
                if node.left:
                    queue.append((node.left, depth+1))
                if node.right:
                    queue.append((node.right, depth+1))