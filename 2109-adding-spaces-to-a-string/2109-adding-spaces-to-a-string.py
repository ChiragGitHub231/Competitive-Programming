class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        n = len(s)
        space_index = 0
        ans = []
        
        for i in range(n):
            if space_index < len(spaces) and spaces[space_index] == i:
                ans.append(" ")
                space_index += 1
            ans.append(s[i])
        
        return "".join(ans)