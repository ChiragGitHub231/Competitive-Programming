class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        INF = 10 ** 20
        events.sort()
        
        best_previous = -INF
        best = max(v for _, _, v in events)
        
        h = []
        for start, end, value in events:
            while len(h) > 0 and h[0][0] <= start:
                _, nv = heapq.heappop(h)
                best_previous = max(best_previous, nv)
        
            heapq.heappush(h, (end + 1, value))
            best = max(best, best_previous + value)
        
        return best