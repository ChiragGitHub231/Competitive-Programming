class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int knownRollTotal = 0;
        for(int roll : rolls) knownRollTotal += roll;
        
        int meanRollTotal = mean * (n + rolls.length);
        int nRollTotal = meanRollTotal - knownRollTotal;
        if(nRollTotal < n || nRollTotal > 6 * n) return new int[]{};
        
        int value = nRollTotal / n;
        int extra = nRollTotal % n;
        int[] result = new int[n];
        for(int i=0; i<result.length; i++) result[i] = value + (i < extra ? 1 : 0);
        
        return result;
    }
}