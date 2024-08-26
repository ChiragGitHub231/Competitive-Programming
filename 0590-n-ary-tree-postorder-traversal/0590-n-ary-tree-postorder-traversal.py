"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        arr = []
        stack = []
        
        if root is not None:
            stack.append([root, 0])
            
        while len(stack) > 0:
            node, index = stack[-1]
            
            if index >= len(node.children):
                arr.append(node.val)
                stack.pop()
            else:
                stack[-1][1] += 1
                stack.append([node.children[index], 0])
        
        return arr