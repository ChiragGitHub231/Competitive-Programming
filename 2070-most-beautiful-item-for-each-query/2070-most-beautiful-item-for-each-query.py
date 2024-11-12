class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        items.sort(key=lambda item: (item[0], -item[1]))
        
        best = 0
        pitems = []
        for p, b in items:
            best = max(b, best)
            pitems.append((p, best))
        
        ans = []
        for q in queries:
            index = bisect.bisect_left(pitems, (q+1, -1))
            
            if index-1 >= 0:
                ans.append(pitems[index-1][1])
            else:
                ans.append(0)
        
        return ans