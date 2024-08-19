class Solution:
    def minSteps(self, n: int) -> int:
        start = (1, 0)
        
        q = collections.deque()
        q.append(start)
        distance = {}
        distance[start] = 0
        
        while len(q) > 0:
            c, b = q.popleft()
            d = distance[(c, b)]
            
            if c == n:
                return d
            
            if (c, c) not in distance:
                distance[(c, c)] = d + 1
                q.append((c, c))
            
            if b > 0 and c + b <= n and (c + b, b) not in distance:
                distance[(c + b, b)] = d + 1
                q.append((c + b, b))
                
        return -1