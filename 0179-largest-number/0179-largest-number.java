class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0; i<nums.length; i++) strs[i] = Integer.toString(nums[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j){
                String s1 = i+j;
                String s2 = j+i;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++) sb.append(strs[i]);
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}