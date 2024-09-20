class Solution {
    private long modPow(int base, int exp, int mod){
        long result = 1;
        long power = base;
        
        while(exp > 0){
            if((exp & 1) == 1) result = (result * power) % mod;
            power = (power * power) % mod;
            exp >>= 1;
        }
        
        return result;
    }
    
    public String shortestPalindrome(String s) {
        int POW = 7;
        int MOD = 1_000_000_007;
        long forwardHash = 0;
        long reverseHash = 0;
        int palindromeEndIndex = -1;
        int n = s.length();
        
        for(int i=0; i<n; i++){
            int currentCharValue = s.charAt(i);
            forwardHash = (forwardHash + currentCharValue * modPow(POW, i, MOD)) % MOD;
            reverseHash = (reverseHash * POW + currentCharValue) % MOD;
            if(forwardHash == reverseHash) palindromeEndIndex = i;
        }
        
        String suffix = s.substring(palindromeEndIndex + 1);
        String reversedSuffix = new StringBuilder(suffix).reverse().toString();
        
        return reversedSuffix + s;
    }
}