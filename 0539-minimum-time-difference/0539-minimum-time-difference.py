class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        N = len(timePoints)
        INF = 10 ** 20
        
        def convert_to_minutes(s):
            hh, mm = map(int, s.split(":"))
            return hh * 60 + mm
        
        tp = sorted(convert_to_minutes(x) for x in timePoints)
        
        best = INF
        for i in range(N - 1):
            best = min(best, tp[i + 1] - tp[i])
        
        best = min(best, (tp[0] + 60 * 24) - tp[-1])
        return best