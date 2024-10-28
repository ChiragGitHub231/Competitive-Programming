class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        
        Map<Integer, Integer> mp = new HashMap<>();
        int result = -1;
        
        for(int x : nums) {
            int sqrt = (int)Math.sqrt(x);
            if(sqrt * sqrt == x && mp.containsKey(sqrt)) {
                mp.put(x, mp.get(sqrt) + 1);
                result = Math.max(result, mp.get(x));
            } else {
                mp.put(x, 1);
            }
        }
        
        return result;
    }
}