class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        N=len(customers)
        total=0
        
        for i in range(N):
            if grumpy[i]==0:
                total+=customers[i]
        
        best=0
        current=0
        for right in range(N):
            if grumpy[right]==1:
                current+=customers[right]
            
            left=right-minutes
            if left>=0 and grumpy[left]==1:
                current-=customers[left]
            
            best=max(best,total+current)
        
        return best