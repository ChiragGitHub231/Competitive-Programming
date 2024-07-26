class Solution:
    def findTheCity(self, N: int, edges: List[List[int]], distanceThreshold: int) -> int:
        INF = 10 ** 20
        
        d = [[INF] * N for _ in range(N)]
        for i in range(N):
            d[i][i] = 0
            
        for u, v, w in edges:
            d[u][v] = w
            d[v][u] = w
        
        for k in range(N):
            for i in range(N):
                for j in range(N):
                    d[i][j] = min(d[i][j], d[i][k] + d[k][j])
        
        best_city = None
        best_reachable = INF
        
        for i in range(N):
            reachable = 0
            
            for j in range(N):
                if d[i][j] <= distanceThreshold:
                    reachable += 1
            
            if reachable <= best_reachable:
                best_city = i
                best_reachable = reachable
        
        return best_city