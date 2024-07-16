# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        
        found = None
        
        def find(node):
            if node is None:
                return
            
            if node.val == startValue:
                nonlocal found
                found = node
            
            find(node.left)
            find(node.right)
            
        find(root)
        
        def construct_parent(node, parent):
            if node is None:
                return
            
            node.parent = parent
            construct_parent(node.left, node)
            construct_parent(node.right, node)
        
        construct_parent(root, None)
        
        previous = {}
        q = collections.deque()
        q.append(found)
        
        previous[found.val] = (None, None)
        last_node = None
        while len(q) > 0:
            node = q.popleft()
            
            if node.val == destValue:
                last_node = node
                break
            
            for nnode, path in [(node.left, "L"), (node.right, "R"), (node.parent, "U")]:
                if nnode is not None and nnode.val not in previous:
                    q.append(nnode)
                    previous[nnode.val] = (node, path)
                    
        ans = []
        current = last_node
        
        while current is not None:
            node, path = previous[current.val]
            ans.append(path)
            current = node
        
        ans.reverse()
        return "".join(ans[1:])