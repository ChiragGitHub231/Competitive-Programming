# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        level_sum = []
        def traverse(node, level):
            if node is None:
                return
            
            if level >= len(level_sum):
                level_sum.append(0)
                
            level_sum[level] += node.val
            
            traverse(node.left, level + 1)
            traverse(node.right, level + 1)
        
        traverse(root, 0)
        level_sum.sort(reverse=True)
        
        if k - 1 >= len(level_sum):
            return -1
        
        return level_sum[k - 1]