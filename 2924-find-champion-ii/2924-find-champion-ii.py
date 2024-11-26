class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        losses = [0] * n
        
        for u, v in edges:
            losses[v] += 1
        
        ans = []
        for i in range(n):
            if losses[i] == 0:
                ans.append(i)
        
        if len(ans) > 1:
            return -1
        
        return ans[0]