class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for(int num : nums) total = (total + num) % p;
        if(total % p == 0) return 0;
        
        int rem = total;
        Map<Integer, Integer> locs = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int current = 0;
        
        locs.put(0, -1);
        for(int i=0; i<nums.length; i++){
            current = (current + nums[i]) % p;
            int target = (current - rem + p) % p;
            if(locs.containsKey(target)) res = Math.min(res, i - locs.get(target));
            locs.put(current, i);
        }
        
        return res < nums.length ? res : -1;
    }
}