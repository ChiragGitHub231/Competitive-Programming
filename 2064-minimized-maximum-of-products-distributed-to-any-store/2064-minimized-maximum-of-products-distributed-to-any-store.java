class Solution {
    private boolean canSplit(int maxCapacity, int n, int[] quantities) {
        int result = 0;
        for(int q : quantities) result += q / maxCapacity + (q % maxCapacity == 0 ? 0 : 1);
        return result <= n;
    }
    
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 0;
        for(int q : quantities) r = Math.max(r, q);
        
        int result = r;
        while(l <= r) {
            int p = l + (r - l) / 2;
            if(canSplit(p, n, quantities)) {
                result = p;
                r = result - 1;
            } else l = p + 1;
        }
        
        return result;
    }
}