class Solution {
    public long minEnd(int n, int x) {
        int i = 0;
        long m = n, result = x;
        m--;
        
        while(m > 0) {
            while(((1L << i) & result) != 0) i++;
            result |= ((m & 1) << i);
            i++;
            m >>= 1;
        }
        
        return result;
    }
}