# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        nodes = collections.defaultdict(list)
        
        def traverse(node, level):
            if node is None:
                return
        
            nodes[level].append(node.val)
            
            traverse(node.left, level + 1)
            traverse(node.right, level + 1)
        
        traverse(root, 0)
        
        def count(arr):
            lookup = {}
            sarr = sorted(arr)
            for index, x in enumerate(sarr):
                lookup[x] = index
            
            narr = [lookup[x] for x in arr]
            ops = 0
            
            for i in range(len(arr)):
                while narr[i] != i:
                    t = narr[narr[i]]
                    narr[narr[i]] = narr[i]
                    narr[i] = t
                    ops += 1
            return ops
        
        ops = 0
        for level in nodes.keys():
            current = nodes[level]
            ops += count(current)
        
        return ops