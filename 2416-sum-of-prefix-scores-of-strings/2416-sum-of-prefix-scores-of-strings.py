class Node:
    def __init__(self):
        self.edges = {}
        self.count = 0

class Trie:
    def __init__(self):
        self.root = Node()
    
    def add(self, word):
        current = self.root
        
        for c in word:
            if c not in current.edges:
                current.edges[c] = Node()
            current = current.edges[c]
            current.count += 1
            
    def count(self, word):
        current = self.root
        r = 0
            
        for c in word:
            current = current.edges[c]
            r += current.count
            
        return r

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        t = Trie()
        
        ans = []
        count = 0
        for word in words:
            t.add(word)
            
        for word in words:
            ans.append(t.count(word))
        
        return ans