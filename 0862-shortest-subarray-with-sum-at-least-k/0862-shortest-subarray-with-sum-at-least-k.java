class Solution {
    public int shortestSubarray(int[] nums, int k) {
        ArrayDeque<long[]> window = new ArrayDeque<>();
        window.add(new long[]{-1, 0});
        long result = Integer.MAX_VALUE, total = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= k) return 1;
            
            total += nums[i];
            while(!window.isEmpty() && window.getLast()[1] >= total) window.removeLast();
            
            window.add(new long[]{i, total});
            while(window.size() >= 2 && window.getLast()[1] - window.getFirst()[1] >= k) {
                result = Math.min(result, window.getLast()[0] - window.getFirst()[0]);
                window.removeFirst();
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : (int) result;
    }
}