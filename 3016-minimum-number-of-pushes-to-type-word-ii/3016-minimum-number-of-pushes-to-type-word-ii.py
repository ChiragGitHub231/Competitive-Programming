class Solution:
    def minimumPushes(self, word: str) -> int:
        ws = sorted(collections.Counter(word).values(), reverse=True)
        
        total = 0
        for index, v in enumerate(ws):
            total += v * (index // 8 + 1)
        
        return total