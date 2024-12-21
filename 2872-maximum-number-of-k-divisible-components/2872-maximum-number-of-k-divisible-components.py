class Solution:
    def maxKDivisibleComponents(self, N: int, edges: List[List[int]], values: List[int], k: int) -> int:
        adjacency_list = collections.defaultdict(list)
        
        for u, v in edges:
            adjacency_list[u].append(v)
            adjacency_list[v].append(u)
        
        def traverse(node, parent):
            stsumt = numt = 0
            for v in adjacency_list[node]:
                if v != parent:
                    stsum, num = traverse(v, node)
                    stsumt += stsum
                    numt += num
            
            stsumt += values[node]
            if stsumt % k == 0:
                numt += 1
            
            return stsumt, numt;
        
        _, num = traverse(0, -1)
        return num