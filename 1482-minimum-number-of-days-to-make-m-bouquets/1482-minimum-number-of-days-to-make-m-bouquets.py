class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        head=0
        tail=10**9
        
        def good(x):
            count=0
            run=0
            
            for day in bloomDay:
                if x>=day:
                    run+=1
                else:
                    run=0
                
                if run>=k:
                    count+=1
                    run=0
            return count>=m
        
        while head<tail:
            mid=(head+tail)//2
            if good(mid):
                tail=mid
            else:
                head=mid+1
        
        if head>max(bloomDay):
            return -1
        
        return head