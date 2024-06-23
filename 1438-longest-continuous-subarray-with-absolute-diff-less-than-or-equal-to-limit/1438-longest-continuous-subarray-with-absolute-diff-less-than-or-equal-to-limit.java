class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> inc = new ArrayDeque<>();
        ArrayDeque<Integer> dec = new ArrayDeque<>();
        int result = 0, left = 0;
        
        for(int i=0; i<nums.length; i++){
            while(!inc.isEmpty() && inc.getLast() > nums[i]) inc.removeLast();
            while(!dec.isEmpty() && dec.getLast() < nums[i]) dec.removeLast();
            inc.addLast(nums[i]);
            dec.addLast(nums[i]);
            
            while(dec.getFirst() - inc.getFirst() > limit){
                if(dec.getFirst() == nums[left]) dec.removeFirst();
                if(inc.getFirst() == nums[left]) inc.removeFirst();
                left++;
            }
            result = Math.max(result,i-left+1);
        }
        return result;
    }
}