class Solution:
    def validArrangement(self, pairs: List[List[int]]) -> List[List[int]]:
        d = defaultdict(list)
        counter = defaultdict(int)
        
        for i in pairs:
            d[i[0]].append(i[1])
            counter[i[0]] += 1
            counter[i[1]] -= 1
        
        start = pairs[0][0]
        for i in d.keys():
            if counter[i] == 1:
                start = i
                break
        
        ans = []
        def dfs(u):
            while d[u]:
                v = d[u].pop()
                dfs(v)
                ans.append([u, v])
        
        dfs(start)
        
        return ans[::-1]