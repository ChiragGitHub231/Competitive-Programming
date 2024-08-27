class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        adj_list = collections.defaultdict(list)
        
        for (u, v), w in zip(edges, succProb):
            adj_list[u].append((v, w))
            adj_list[v].append((u, w))
            
        best = [0.0] * n
        used = [False] * n
        h = []
        best[start] = 1.0
        heapq.heappush(h, (-1.0, start))
        
        while len(h) > 0:
            p, node = heapq.heappop(h)
            p *= -1
            
            if used[node]:
                continue
            
            used[node] = True
            
            for v, w in adj_list[node]:
                q = p * w
                if q > best[v]:
                    heapq.heappush(h, (-q, v))
                    best[v] = q
            
        return best[end]