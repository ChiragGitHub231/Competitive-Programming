class UnionFind:
    def __init__(self, N):
        self.N = N
        self.parents = [i for i in range(N)]
        
    def ufind(self, x):
        if self.parents[x] != x:
            self.parents[x] = self.ufind(self.parents[x])
        return self.parents[x]
    
    def uunion(self, a, b):
        ua = self.ufind(a)
        ub = self.ufind(b)
        
        if ua != ub:
            self.parents[ua] = ub
    
    def is_connected(self, a, b):
        return self.ufind(a) == self.ufind(b)

class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        alice = UnionFind(n)
        bob = UnionFind(n)
        
        removed = 0
        for t, x, y in edges:
            x -= 1
            y -= 1
            
            if t == 3:
                if alice.is_connected(x, y):
                    removed += 1
                else:
                    alice.uunion(x, y)
                    bob.uunion(x, y)
        
        for t, x, y in edges:
            x -= 1
            y -= 1
            
            if t == 1:
                current = alice
            elif t == 2:
                current = bob
            else:
                continue
            
            if current.is_connected(x, y):
                removed += 1
            else:
                current.uunion(x, y)
        
        for i in range(n):
            if not alice.is_connected(0, i) or not bob.is_connected(0, i):
                return -1
        else:
            return removed