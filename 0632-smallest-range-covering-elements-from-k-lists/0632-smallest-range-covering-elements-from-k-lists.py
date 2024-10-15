class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        k = len(nums)
        left = right = nums[0][0]
        min_heap = []
        
        for i in range(k):
            l = nums[i]
            left = min(left, l[0])
            right = max(right, l[0])
            heapq.heappush(min_heap, (l[0], i, 0))
        
        result = [left, right]
        
        while True:
            n, i, idx = heapq.heappop(min_heap)
            idx += 1
            if idx == len(nums[i]):
                return result
            
            next_val = nums[i][idx]
            heapq.heappush(min_heap, (next_val, i, idx))
            
            right = max(right, next_val)
            left = min_heap[0][0]
            
            if right - left < result[1] - result[0]:
                result = [left, right]