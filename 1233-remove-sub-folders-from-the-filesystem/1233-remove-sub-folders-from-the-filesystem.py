class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        folder.sort()
        
        stack = []
        
        for f in folder:
            if len(stack) == 0:
                stack.append(f + "/")
                continue
            
            if f.startswith(stack[-1]):
                continue
            else:
                stack.append(f + "/")
        
        return list(f[:-1] for f in stack)