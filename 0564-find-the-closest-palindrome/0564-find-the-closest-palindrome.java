class Solution {
    private long buildPal(long half, boolean isEven){
        String halfStr = Long.toString(half);
        String palinStr;
        if(isEven) palinStr = halfStr + new StringBuilder(halfStr).reverse().toString();
        else palinStr = halfStr + new StringBuilder(halfStr.substring(0, halfStr.length() - 1)).reverse().toString();
        return Long.parseLong(palinStr);
    }
    
    public String nearestPalindromic(String n) {
        int N = n.length();
        if(N == 1) return Integer.toString(Integer.parseInt(n) - 1);
        
        long original = Long.parseLong(n);
        long lessDigits = (long)Math.pow(10, N - 1) - 1;
        long moreDigits = (long)Math.pow(10, N) + 1;
        
        long halfVal = Long.parseLong(n.substring(0, (N + 1) / 2));
        
        long same = buildPal(halfVal, N % 2 == 0);
        long smaller = buildPal(halfVal - 1, N % 2 == 0);
        long bigger = buildPal(halfVal + 1, N % 2 == 0);
        
        long[] candidates = {lessDigits, moreDigits, smaller, same, bigger};
        Arrays.sort(candidates);
        
        long closest = Long.MAX_VALUE;
        for(long candidate : candidates){
            if(candidate == original) continue;
            if(Math.abs(candidate - original) < Math.abs(closest - original)) {
                closest = candidate;
            }
        }
        
        return Long.toString(closest);
    }
}