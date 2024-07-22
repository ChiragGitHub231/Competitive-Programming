class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> mp = new HashMap<>();
        for(int i=0; i<names.length; i++) mp.put(heights[i],names[i]);
        
        String resultArray[] = new String[names.length];
        Arrays.sort(heights);
        int index = 0;
        
        for(int i=heights.length-1; i>=0; i--) resultArray[index++] = mp.get(heights[i]);
        return resultArray;
    }
}