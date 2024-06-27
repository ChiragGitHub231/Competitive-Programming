class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        M = len(edges)
        N = M + 1
        index = collections.defaultdict(int)
        
        for u, v in edges:
            index[u] += 1
            index[v] += 1
            
        return next(x for x, y in index.items() if y>1)