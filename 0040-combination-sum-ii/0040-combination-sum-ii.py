class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        
        res = []
        
        def backtrack(current, position, target):
            if target == 0:
                res.append(current.copy())
            if target <= 0:
                return
            
            previous = -1
            for i in range(position, len(candidates)):
                if candidates[i] == previous:
                    continue
                current.append(candidates[i])
                backtrack(current, i + 1, target - candidates[i])
                current.pop()
                previous = candidates[i]
            
        backtrack([], 0, target)
        
        return res