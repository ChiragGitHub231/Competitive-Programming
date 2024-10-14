class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        h = []
        total = 0
        for x in nums:
            heapq.heappush(h, -x)
        
        for _ in range(k):
            x = -heapq.heappop(h)
            total += x
            x = (x + 2) // 3
            heapq.heappush(h, -x)
        
        return total