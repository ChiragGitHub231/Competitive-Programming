class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        N = len(classes)
        
        h = []
        for p, t in classes:
            h.append((-(((p + 1) / (t + 1)) - (p / t)), p, t))
        heapq.heapify(h)
        
        for _ in range(extraStudents):
            _, p, t = heapq.heappop(h)
            p += 1
            t += 1
            heapq.heappush(h, (-(((p + 1) / (t + 1)) - (p / t)), p, t))
        
        total_ratio = 0.0
        
        for _, p, t in h:
            total_ratio += (p / t)
        
        return total_ratio / N