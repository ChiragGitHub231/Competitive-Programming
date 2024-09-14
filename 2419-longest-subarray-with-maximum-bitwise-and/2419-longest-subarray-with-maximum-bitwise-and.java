class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = 0, result = 0, streak = 0;
        for(int num : nums){
            if(num > maxi){
                maxi = num;
                result = 0;
                streak = 1;
            } else if(num == maxi) streak++;
            else streak = 0;
            result = Math.max(result, streak);
        }
        return result;
    }
}