class Solution {
    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int min = nums[0], max = nums[0];
        
        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i])) mp.put(nums[i], mp.get(nums[i]) + 1);
            else mp.put(nums[i], 1);
            
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        
        int index = 0;
        for(int i=min; i<=max; i++){
            while(mp.getOrDefault(i, 0) > 0){
                nums[index] = i;
                index++;
                mp.put(i, mp.get(i) - 1);
            }
        }
        
        return nums;
    }
}