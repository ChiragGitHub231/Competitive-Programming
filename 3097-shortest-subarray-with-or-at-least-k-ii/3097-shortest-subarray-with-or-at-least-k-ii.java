class Solution {
    private void addBits(int num, int[] bits) {
        int i = 0;
        while(num > 0) {
            bits[i] += num & 1;
            num >>= 1;
            i++;
        }
    }
    
    private void subtractBits(int num, int[] bits) {
        int i = 0;
        while(num > 0) {
            bits[i] -= num & 1;
            num >>= 1;
            i++;
        }
    }
    
    private int currentBitSum(int[] bits) {
        int result = 0;
        for(int i=0; i<32; i++) {
            if(bits[i] > 0) result |= (1 << i);
        }
        return result;
    }
    
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int result = Integer.MAX_VALUE;
        int left = 0;
        
        for(int i=0; i<nums.length; i++) {
            addBits(nums[i], bits);
            
            while(currentBitSum(bits) >= k && left <= i) {
                result = Math.min(result, i - left + 1);
                subtractBits(nums[left], bits);
                left++;
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}