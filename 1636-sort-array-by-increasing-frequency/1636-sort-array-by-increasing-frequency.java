class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        Integer[] ints = new Integer[nums.length];
        
        for(int i=0; i<nums.length; i++){
            ints[i] = nums[i];
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        
        Arrays.sort(ints, (a, b) -> {
            int freqA = mp.get(a);
            int freqB = mp.get(b);
            if(freqA == freqB) return b - a;
            else return freqA - freqB;
        });
        
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++) res[i] = ints[i];
        
        return res;
    }
}