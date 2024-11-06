class Solution {
    private int calculateBits(int num) {
        int counter = 0;
        while(num != 0) {
            counter += (num & 1);
            num >>= 1;
        }
        return counter;
    }
    
    public boolean canSortArray(int[] nums) {
        List<int[]> bits = new ArrayList<>();
        for(int num : nums) bits.add(new int[]{num, calculateBits(num)});
        
        List<int[]> segments = new ArrayList<>();
        int currentMin = bits.get(0)[0];
        int currentMax = bits.get(0)[0];
        int currentBitCount = bits.get(0)[1];
        
        for(int i=1; i<bits.size(); i++) {
            int num = bits.get(i)[0];
            int bitCount = bits.get(i)[1];
            
            if(bitCount != currentBitCount) {
                segments.add(new int[]{currentMin, currentMax});
                currentMin = num;
                currentMax = num;
                currentBitCount = bitCount;
            } else {
                currentMin = Math.min(currentMin, num);
                currentMax = Math.max(currentMax, num);
            }
        }
        
        segments.add(new int[]{currentMin, currentMax});
        
        for(int i=0; i<segments.size() - 1; i++) {
            int[] currentSegment = segments.get(i);
            int[] nextSegment = segments.get(i + 1);
            if(currentSegment[1] > nextSegment[0]) return false;
        }
        
        return true;
    }
}