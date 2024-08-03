class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // return nums[(int)Math.ceil(nums.length/2)];
        
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            if (num == candidate) count++;
            else count--;
        }
        return candidate;
    }
}